
package com.gobeshonabd.pojos;

public class Messages_With_Uname
    {

    private int userID;//0
    private String userFirstName;//1
    private String userLastName;//2
//  1 
    private int MessageID;
//  2
    private String MessageDate;
//  3 
    private int messageSenderID;
//  4 
    private int messageReceiverID;
//  5 
    private String message;
//  6 
    private int readStatus =0 ;
    
    //7 new Added
    private String subject;
    
    
    public Messages_With_Uname()
        {
        
        }

    public Messages_With_Uname(
            int userID, 
            String userFirstName, 
            String userLastName, 
            int MessageID, 
            String MessageDate, 
            int messageSenderID, 
            int messageReceiverID,
            String message,
            int readStatus,
            String subject)
        {
        this.userID         = userID;
        this.userFirstName  = userFirstName;
        this.userLastName   = userLastName;
        this.MessageID      = MessageID;
        this.MessageDate    = MessageDate;
        this.messageSenderID    = messageSenderID;
        this.messageReceiverID  = messageReceiverID;
        this.message    = message;
        this.readStatus = readStatus;
        this.subject    = subject;
        }

    public int getUserID()
        {
        return userID;
        }

    public void setUserID(int userID)
        {
        this.userID = userID;
        }

    public String getUserFirstName()
        {
        return userFirstName;
        }

    public void setUserFirstName(String userFirstName)
        {
        this.userFirstName = userFirstName;
        }

    public String getUserLastName()
        {
        return userLastName;
        }

    public void setUserLastName(String userLastName)
        {
        this.userLastName = userLastName;
        }

    public int getMessageID()
        {
        return MessageID;
        }

    public void setMessageID(int MessageID)
        {
        this.MessageID = MessageID;
        }

    public String getMessageDate()
        {
        return MessageDate;
        }

    public void setMessageDate(String MessageDate)
        {
        this.MessageDate = MessageDate;
        }

    public int getMessageSenderID()
        {
        return messageSenderID;
        }

    public void setMessageSenderID(int messageSenderID)
        {
        this.messageSenderID = messageSenderID;
        }

    public int getMessageReceiverID()
        {
        return messageReceiverID;
        }

    public void setMessageReceiverID(int messageReceiverID)
        {
        this.messageReceiverID = messageReceiverID;
        }

    public String getMessage()
        {
        return message;
        }

    public void setMessage(String message)
        {
        this.message = message;
        }

    public int getReadStatus()
        {
        return readStatus;
        }

    public void setReadStatus(int readStatus)
        {
        this.readStatus = readStatus;
        }

    //**************************************************
    public String getSubject()
        {
        return subject;
        }

    public void setSubject(String subject)
        {
        this.subject = subject;
        }
    
    }
