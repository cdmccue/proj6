package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.annotation.RestEndpoint;
import edu.usm.cos375.springboot.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import edu.usm.cos375.springboot.entity.Discussion;
import edu.usm.cos375.springboot.form.DiscussionForm;
import javax.inject.Inject;
import java.util.List;

@RestEndpoint
@RequestMapping("services/rest")
public class DiscussionRestEndpoint
{
    @Inject DiscussionService discussionService;

    @RequestMapping(value = "discussion", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS,HEAD,GET,POST");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "discussion/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover(@PathVariable("id") long id)
    {
        if(this.discussionService.getDiscussion(id) == null)
            throw new ResourceNotFoundException();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS,HEAD,GET,PUT,DELETE");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "discussion", method = RequestMethod.GET)
    @ResponseBody @ResponseStatus(HttpStatus.OK)
    public List<Discussion> read()
    {
        List<Discussion> list = this.discussionService.getAllDiscussions();
        return list;
    }

    @RequestMapping(value = "discussion/{id}", method = RequestMethod.GET)
    @ResponseBody @ResponseStatus(HttpStatus.OK)
    public Discussion read(@PathVariable("id") long id)
    {
        Discussion discussion = this.discussionService.getDiscussion(id);
        if(discussion == null)
            throw new ResourceNotFoundException();
        return discussion;
    }

    @RequestMapping(value = "discussion", method = RequestMethod.POST)
    public ResponseEntity<Discussion> create(@RequestBody DiscussionForm form)
    {
        Discussion discussion = new Discussion();
        
        discussion.setUser(form.getUser());
        discussion.setSubject(form.getSubject());
        discussion.setMessage(form.getMessage());
        this.discussionService.saveDiscussion(discussion);

        String uri = ServletUriComponentsBuilder.fromCurrentServletMapping()
                .path("/discussion/{id}").buildAndExpand(discussion.getId()).toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(discussion, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "discussion/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody DiscussionForm form)
    {
        Discussion discussion = this.discussionService.getDiscussion(id);
        if(discussion == null)
            throw new ResourceNotFoundException();
        discussion.setUser(form.getUser());
        discussion.setSubject(form.getSubject());
        discussion.setMessage(form.getMessage());
        this.discussionService.saveDiscussion(discussion);
    }

    @RequestMapping(value = "discussion/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id)
    {
        if(this.discussionService.getDiscussion(id) == null)
            throw new ResourceNotFoundException();
        this.discussionService.deleteDiscussion(id);
    }
}
