package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import edu.usm.cos375.springboot.form.DiscussionForm;
import edu.usm.cos375.springboot.annotation.WebController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import javax.inject.Inject;
import java.util.Map;

@WebController
@RequestMapping("discussion")
public class BoardController
{
    @Inject DiscussionService discussionService;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String listDiscussions(Map<String, Object> model) //throws JsonProcessingException
    {   
    	    model.put("discussions", this.discussionService.getAllDiscussions());
        return "discussion/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createDiscussion(Map<String, Object> model)
    {
        model.put("discussionForm", new DiscussionForm());
        return "discussion/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public View createDiscussion(DiscussionForm form)
    {
        Discussion discussion = new Discussion();
        
        discussion.setStreet(form.getStreet());
        discussion.setTown(form.getTown());
        discussion.setUser(form.getUser());
        discussion.setSubject(form.getSubject());
        discussion.setMessage(form.getMessage());
        this.discussionService.saveDiscussion(discussion);

        return new RedirectView("/discussion/" + discussion.getId() + "/" +
                discussion.getUriSafeSubject(), true, false);
    }
}