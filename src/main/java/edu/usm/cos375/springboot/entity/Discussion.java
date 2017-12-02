package edu.usm.cos375.springboot.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import edu.usm.cos375.springboot.validation.NotBlank;

public class Discussion
{
    private long id;
    private String town;
    private String street;
    
    @NotBlank(message = "{validate.discussion.user}")
    private String user;
    @NotBlank(message = "{validate.discussion.subject}")
    private String subject;
    @NotBlank(message = "{validate.discussion.message}")
    private String message;
    private Instant created;
    
    private String uriSafeSubject;
    private Instant lastUpdated;
    private Set<String> subscribedUsers = new HashSet<>();
    
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
    
    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }
    
    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
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
    
    public Instant getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public Set<String> getSubscribedUsers()
    {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<String> subscribedUsers)
    {
        this.subscribedUsers = subscribedUsers;
    }
    
    public String getUriSafeSubject()
    {
        return uriSafeSubject;
    }

    public void setUriSafeSubject(String uriSafeSubject)
    {
        this.uriSafeSubject = uriSafeSubject;
    }
    
}