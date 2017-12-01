package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Discussion;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryDiscussionRepository implements DiscussionRepository
{
    private final Map<Long, Discussion> database = new Hashtable<>();
    private volatile long discussionIdSequence = 1L;
    @Inject PostRepository postRepository;
    
    @Override
    public List<Discussion> getAll()
    {
        return new ArrayList<>(this.database.values());
    }

    @Override
    public Discussion get(long id)
    {
        return this.database.get(id);
    }

    @Override
    public void add(Discussion discussion)
    {
        discussion.setId(this.getNextDiscussionId());
        this.database.put(discussion.getId(), discussion);
    }

    @Override
    public void update(Discussion discussion)
    {
        this.database.put(discussion.getId(), discussion);
    }

    @Override
    public void delete(long id)
    {
        this.database.remove(id);
        this.postRepository.deleteForDiscussion(id);
    }

    private synchronized long getNextDiscussionId()
    {
        return this.discussionIdSequence++;
    }
}
