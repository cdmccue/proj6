package edu.usm.cos375.springboot.form;

public class DiscussionForm
{
	private String town;
	private String street;
    private String user;
    private String subject;
    private String message;

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
