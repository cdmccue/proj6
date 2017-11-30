package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Post;
import java.util.List;

public interface PostService {

    List<Post> getPostsForDiscussion(long discussionId);
    void savePost(Post post);
}