package edu.usm.cos375.springboot.controller;

//import edu.usm.cos375.springboot.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import java.util.Map;

@Controller
@RequestMapping("discussion")
public class BoardController
{
    @Inject PostService postService;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String listDiscussions(Map<String, Object> model)
    {
        model.put("posts", this.postService.getPostsForDiscussion(1));
        return "discussion/list";
    }
}
