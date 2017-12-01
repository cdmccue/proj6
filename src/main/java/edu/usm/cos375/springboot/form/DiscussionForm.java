package edu.usm.cos375.springboot.form;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "discussion")
public class DiscussionForm
{
    private String user;
    private String subject;
    private String message;

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
}
