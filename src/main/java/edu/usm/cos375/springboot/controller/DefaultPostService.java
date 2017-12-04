package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import edu.usm.cos375.springboot.entity.Post;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DefaultPostService implements PostService
{
    @Inject PostRepository postRepository;
    @Inject DiscussionService discussionService;

    @Override
    public List<Post> getPostsForDiscussion(long discussionId)
    {
    	
        List<Post> list = this.postRepository.findByDiscussionId(discussionId);
        list.sort((r1, r2) -> r1.getId() < r2.getId() ? -1 : 1);
        return list;
    }

    @Override
    public void savePost(Post post)
    {
        Discussion discussion =
                this.discussionService.getDiscussion(post.getDiscussionId());
//        if(post.getId() < 1)
//        {
//        	    Instant inst = Instant.now();
//        	    Date now = Date.from(inst);
//        	    
////            discussion.getSubscribedUsers().add(post.getUser());
//            post.setCreated(now);
////            this.postRepository.add(post);
//            this.postRepository.save(post);
//
////            Set<String> recipients = new HashSet<>(discussion.getSubscribedUsers());
////            recipients.remove(post.getUser()); // no need to email replier
//        }
//        else
//        {
////            this.postRepository.update(post);
//        }
        this.postRepository.save(post);
        this.discussionService.saveDiscussion(discussion);
    }
}
