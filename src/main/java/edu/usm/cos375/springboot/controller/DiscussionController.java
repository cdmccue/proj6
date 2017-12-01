package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import edu.usm.cos375.springboot.entity.Post;
import edu.usm.cos375.springboot.form.PostForm;
import edu.usm.cos375.springboot.annotation.WebController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import edu.usm.cos375.springboot.controller.PostService;
import javax.inject.Inject;
import java.util.Map;

@WebController
@RequestMapping("discussion/{discussionId:\\d+}")
public class DiscussionController
{
    @Inject DiscussionService discussionService;
    @Inject PostService postService;

    @RequestMapping(value = {"", "*"}, method = RequestMethod.GET)
    public String viewDiscussion(Map<String, Object> model,
                                 @PathVariable("discussionId") long id)
    {
        Discussion discussion = this.discussionService.getDiscussion(id);
        if(discussion != null)
        {
            model.put("discussion", discussion);
            model.put("replies", this.postService.getPostsForDiscussion(id));
            model.put("postForm", new PostForm());
            return "discussion/view";
        }

        return "discussion/errorNoDiscussion";
    }
    
    @RequestMapping(value = "post", method = RequestMethod.POST)
    public ModelAndView post(PostForm form,
                              @PathVariable("discussionId") long id)
    {
        Discussion discussion = this.discussionService.getDiscussion(id);
        if(discussion != null)
        {
            Post post = new Post();
            
            post.setDiscussionId(id);
            post.setUser(form.getUser());
            post.setMessage(form.getMessage());
            this.postService.savePost(post);

            return new ModelAndView(new RedirectView("/discussion/" + id + "/" +
                    discussion.getUriSafeSubject(), true, false));
        }

        return new ModelAndView("discussion/errorNoDiscussion");
    }
}
