
package org.gobeshona.pojos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Messages
    {

//  1 Auto, Increment.
    private int MessageID;
//  2
    private String MessageDate;
//  3 
//    @NotEmpty
    private int messageSenderID;
//  4 
//    @NotEmpty
    private int messageReceiverID;
//  5 length="5000"
//    @NotEmpty
    @Length(max = 5000)
    private String message;
//  6 read status
    private int readStatus =0 ;
    
    //New Added
    private String subject  = "Message Subject";
    
    public Messages()
        {
        
        }

    public Messages(
            int MessageID, 
            String MessageDate, 
            int MessageSenderID, 
            int MessageReceiverID, 
            String Message,
            int readStatus)
        {
        this.MessageID = MessageID;
        this.MessageDate = MessageDate;
        this.messageSenderID = MessageSenderID;
        this.messageReceiverID = MessageReceiverID;
        this.message = Message;
        this.readStatus = readStatus;
        }

//  1  **************************************************************************    
    public int getMessageID()
        {
        return MessageID;
        }    
    public void setMessageID(int MessageID)
        {
        this.MessageID = MessageID;
        }
//  2 **************************************************************************    
    public String getMessageDate()
        {
        return MessageDate;
        }    
    public void setMessageDate(String MessageDate)
        {
        this.MessageDate = MessageDate;
        }
//  3  **************************************************************************    
    public int getMessageSenderID()
        {
        return messageSenderID;
        }    
    public void setMessageSenderID(int MessageSenderID)
        {
        this.messageSenderID = MessageSenderID;
        }
//  4  **************************************************************************    
    public int getMessageReceiverID()
        {
        return messageReceiverID;
        }    
    public void setMessageReceiverID(int MessageReceiverID)
        {
        this.messageReceiverID = MessageReceiverID;
        }
//  5  **************************************************************************
    public String getMessage()
        {
        return message;
        }
    public void setMessage(String Message)
        {
        this.message = Message;
        }
//  6  **************************************************************************
    public int getReadStatus()
        {
        return readStatus;
        }

    public void setReadStatus(int readStatus)
        {
        this.readStatus = readStatus;
        }

//  7  Newly Added **************************************************************************
    public String getSubject()
        {
        return subject;
        }

    public void setSubject(String subject)
        {
        this.subject = subject;
        }

    }
