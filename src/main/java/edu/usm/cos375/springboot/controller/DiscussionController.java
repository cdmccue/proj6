//package edu.usm.cos375.springboot.controller;
//
//import edu.usm.cos375.springboot.entity.Discussion;
////import edu.usm.cos375.springboot.entity.Post;
////import edu.usm.cos375.springboot.form.PostForm;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
////import org.springframework.web.servlet.ModelAndView;
////import org.springframework.web.servlet.view.RedirectView;
//
//import javax.inject.Inject;
//import java.util.Map;
//
//@Controller
//@RequestMapping("discussion/{discussionId:\\d+}")
//public class DiscussionController
//{
//    @Inject DiscussionService discussionService;
//
//    @RequestMapping(value = {"", "*"}, method = RequestMethod.GET)
//    public String viewDiscussion(Map<String, Object> model,
//                                 @PathVariable("discussionId") long id)
//    {
//        Discussion discussion = this.discussionService.getDiscussion(id);
//        if(discussion != null)
//        {
//            model.put("discussion", discussion);
//            return "discussion/view";
//        }
//
//        return "discussion/errorNoDiscussion";
//    }
//}
