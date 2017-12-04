package edu.usm.cos375.springboot.controller;

import java.util.List;

import edu.usm.cos375.springboot.entity.Post;
import org.springframework.data.repository.CrudRepository;


//public interface PostRepository extends GenericRepository<Long, Post>
//{
//    List<Post> getForDiscussion(long id);
////    void add(Post post);
////    void update(Post post);
//    void deleteForDiscussion(long id);
//}

public interface PostRepository extends CrudRepository<Post, Long> {
	
	List<Post> findByDiscussionId(long discussionId);
}
