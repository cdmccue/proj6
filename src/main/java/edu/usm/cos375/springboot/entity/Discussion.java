package edu.usm.cos375.springboot.entity;

import java.time.Instant;

public class Discussion
{
    private long id;
    private String user;
    private String subject;
    private String message;
    private Instant created;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Instant getCreated()
    {
        return created;
    }

    public void setCreated(Instant created)
    {
        this.created = created;
    }
}