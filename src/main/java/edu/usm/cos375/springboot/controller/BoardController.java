package edu.usm.cos375.springboot.controller;

//import edu.usm.cos375.springboot.entity.Discussion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.view.RedirectView;

import edu.usm.cos375.springboot.entity.Discussion;

import javax.inject.Inject;

import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
@RequestMapping("discussion")
public class BoardController
{
    @Inject DiscussionService discussionService;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String listDiscussions(Map<String, Object> model) throws JsonProcessingException
    {   
    	
    	    ObjectMapper mapper = new ObjectMapper();
    	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	    String ListToJson = mapper.writeValueAsString(this.discussionService.getAllDiscussions());
    	    
        model.put("discussions", ListToJson);
        return "discussion/list";
    }

//    @RequestMapping(value = "create", method = RequestMethod.GET)
//    public String createDiscussion(Map<String, Object> model)
//    {
//        model.put("discussionForm", new DiscussionForm());
//        return "discussion/create";
//    }
//
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public View createDiscussion(DiscussionForm form)
//    {
//        Discussion discussion = new Discussion();
//        
//        discussion.setUser(form.getUser());
//        discussion.setSubject(form.getSubject());
//        discussion.setMessage(form.getMessage());
//        this.discussionService.saveDiscussion(discussion);
//
//        return new RedirectView("/discussion/" + discussion.getId() + "/" +
//                discussion.getUriSafeSubject(), true, false);
//    }
}