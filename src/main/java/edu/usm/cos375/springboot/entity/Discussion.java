package edu.usm.cos375.springboot.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import edu.usm.cos375.springboot.validation.NotBlank;


@Entity
@Table(name = "Discussions", indexes = {
		@Index(name = "twn", columnList = "Town")
})
public class Discussion implements Serializable
{
	@Column(name = "DiscussionId")
    private long id;
    private String town;
    private String street;
    
    @NotBlank(message = "{validate.discussion.user}")
    private String user;
    @NotBlank(message = "{validate.discussion.subject}")
    private String subject;
    @NotBlank(message = "{validate.discussion.message}")
    private String message;
    private Date created;
    
    private String uriSafeSubject;
    private Date lastUpdated;
    private Set<String> subscribedUsers = new HashSet<>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscussionId")
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "UserName")
    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }
    
    @Basic
    @Column(name = "Town")
    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }
    
    @Basic
    @Column(name = "Street")
    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    @Basic
    @Column(name = "Subj")
    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    @Basic
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

//    @ElementCollection
//    public Set<String> getSubscribedUsers()
//    {
//        return subscribedUsers;
//    }
//
//    public void setSubscribedUsers(Set<String> subscribedUsers)
//    {
//        this.subscribedUsers = subscribedUsers;
//    }
    
    @Basic
    public String getUriSafeSubject()
    {
        return uriSafeSubject;
    }

    public void setUriSafeSubject(String uriSafeSubject)
    {
        this.uriSafeSubject = uriSafeSubject;
    }
    
}