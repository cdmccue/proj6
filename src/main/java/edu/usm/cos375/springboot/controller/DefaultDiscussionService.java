package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.Normalizer;
import java.time.Instant;
//import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DefaultDiscussionService implements DiscussionService
{

    @Inject DiscussionRepository discussionRepository;

    @Override
    public List<Discussion> getAllDiscussions()
    {
        List<Discussion> list = this.discussionRepository.getAll();
//        list.sort((d1, d2) -> d1.getLastUpdated().compareTo(d2.getLastUpdated()));
        return list;
    }

    @Override
    public Discussion getDiscussion(long id)
    {
        return this.discussionRepository.get(id);
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

        Instant now = Instant.now();
        discussion.setLastUpdated(now);

        if(discussion.getId() < 1)
        {
            discussion.setCreated(now);
            discussion.getSubscribedUsers().add(discussion.getUser());
            this.discussionRepository.add(discussion);
        }
        else
            this.discussionRepository.update(discussion);
    }
}
