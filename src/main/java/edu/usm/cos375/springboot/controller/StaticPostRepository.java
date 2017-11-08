package edu.usm.cos375.springboot.controller;

import edu.usm.cos375.springboot.entity.Post;
import edu.usm.cos375.springboot.controller.PostRepository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Repository
public class StaticPostRepository implements PostRepository
{
    private static final Map<Long, Post> database = new Hashtable<>();
    private volatile long postIdSequence = 1L;
    
    static {
        database.put(1, "password");
        database.put(1, "drowssap");
    }

    @Override
    public List<Post> getForDiscussion(long id)
    {
        ArrayList<Post> list = new ArrayList<>(this.database.values());
        list.removeIf(r -> r.getDiscussionId() != id);
        return list;
    }

    @Override
    public synchronized void create(Post post)
    {
        post.setId(this.getNextPostId());
        this.database.put(post.getId(), post);
    }

    @Override
    public synchronized void update(Post post)
    {
        this.database.put(post.getId(), post);
    }

    @Override
    public synchronized void deleteForDiscussion(long id)
    {
        this.database.entrySet()
                .removeIf(e -> e.getValue().getDiscussionId() == id);
    }

    private synchronized long getNextPostId()
    {
        return this.postIdSequence++;
    }
}

