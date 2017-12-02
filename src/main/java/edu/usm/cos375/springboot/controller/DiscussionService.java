package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface DiscussionService
{
	@NotNull
    List<Discussion> getAllDiscussions();
    Discussion getDiscussion(long id);
    void saveDiscussion(
    		@NotNull(message = "{validate.discussionService.saveDiscussion.discussion}")
        @Valid Discussion discussion);
    void deleteDiscussion(long id);
}
