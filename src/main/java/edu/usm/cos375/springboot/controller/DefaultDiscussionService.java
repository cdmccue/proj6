package edu.usm.cos375.springboot.controller;

import org.springframework.transaction.annotation.Transactional;
import edu.usm.cos375.springboot.entity.Discussion;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.text.Normalizer;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Service
public class DefaultDiscussionService implements DiscussionService
{

    @Inject DiscussionRepository discussionRepository;
    
    private <E> List<E> toList(Iterable<E> i)
    {
        List<E> list = new ArrayList<>();
        i.forEach(list::add);
        return list;
    }

    @Override
    @Transactional
    public List<Discussion> getAllDiscussions()
    {
//    	      return this.toList(this.discussionRepository.getAll());
    	  return this.toList(this.discussionRepository.findAll());
    }

    @Override
    public Discussion getDiscussion(long id)
    {
//        return this.discussionRepository.get(id);
    	return this.discussionRepository.findOne(id);
    }

    @Override
    public void saveDiscussion(Discussion discussion)
    {
        String subject = discussion.getSubject();
        subject = Normalizer.normalize(subject.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{Alnum}]+", "-")
                .replace("--", "-").replace("--", "-")
                .replaceAll("[^a-z0-9]+$", "")
                .replaceAll("^[^a-z0-9]+", "");
        discussion.setUriSafeSubject(subject);

        Instant inst = Instant.now();
        Date now = Date.from(inst);
//        discussion.setLastUpdated(now);
//        discussion.setCreated(now);
        
        //changed add to save
        this.discussionRepository.save(discussion);

//        if(discussion.getId() < 1)
//        {
//            discussion.setCreated(now);
////            discussion.getSubscribedUsers().add(discussion.getUser());
//            this.discussionRepository.add(discussion);
//        }
//        else
//            this.discussionRepository.update(discussion);
    }
    
    @Override
    public void deleteDiscussion(long id)
    {
//        this.discussionRepository.deleteById(id);
    	  this.discussionRepository.delete(id);
    }
}
