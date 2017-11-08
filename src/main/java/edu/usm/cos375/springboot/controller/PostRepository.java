package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Post;

import java.util.List;

public interface PostRepository
{
    List<Post> getForDiscussion(long id);
    void create(Post post);
    void update(Post post);
    void deleteForDiscussion(long id);
}
