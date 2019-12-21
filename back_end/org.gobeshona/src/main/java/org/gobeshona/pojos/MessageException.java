package org.gobeshona.pojos;

public class MessageException
    {

    private int message_exception_id;
    private int user_who_will_make_exception;
    private int user_who_will_be_made_exception;
    private String date_making_exception;
    
    public int getMessage_exception_id()
        {
        return message_exception_id;
        }

    public void setMessage_exception_id(int message_exception_id)
        {
        this.message_exception_id = message_exception_id;
        }

    public int getUser_who_will_make_exception()
        {
        return user_who_will_make_exception;
        }

    public void setUser_who_will_make_exception(int user_who_will_make_exception)
        {
        this.user_who_will_make_exception = user_who_will_make_exception;
        }

    public int getUser_who_will_be_made_exception()
        {
        return user_who_will_be_made_exception;
        }

    public void setUser_who_will_be_made_exception(int user_who_will_be_made_exception)
        {
        this.user_who_will_be_made_exception = user_who_will_be_made_exception;
        }

    public String getDate_making_exception()
        {
        return date_making_exception;
        }

    public void setDate_making_exception(String date_making_exception)
        {
        this.date_making_exception = date_making_exception;
        }
        
    }
