package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;

import java.util.List;

public interface DiscussionService
{
    List<Discussion> getAllDiscussions();
    Discussion getDiscussion(long id);
    void saveDiscussion(Discussion discussion);
}
