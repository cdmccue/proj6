package edu.usm.cos375.springboot.entity;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

@Entity
@Table(name = "Posts", indexes = {
		@Index(name = "usr", columnList = "UserName")
})
public class Post implements Serializable
{
	private long discussionId;
    private long id;
    private String user;
    private String message;
    private Date created;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostId")
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "DiscussionId")
    public long getDiscussionId()
    {
        return discussionId;
    }

    public void setDiscussionId(long discussionId)
    {
        this.discussionId = discussionId;
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
    @Column(name = "Message")
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
}