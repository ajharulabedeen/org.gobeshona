package com.gobeshonabd.messages;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.messages.DAO_Messages_I;
import com.gobeshonabd.pojos.Messages;
import java.util.List;

public class Services_Messages_Impl
        implements Services_Messages_I,SpringApplicationContextInterface
    {

//   Start Bean Area ***************************
    //Injection..........................
    private DAO_Messages_I dao_Messages_I;
    public DAO_Messages_I getDao_Messages_I()
        {
        return dao_Messages_I;
        }
    public void setDao_Messages_I(DAO_Messages_I dao_Messages_I)
        {
        this.dao_Messages_I = dao_Messages_I;
        }
    //Injection..........................
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");
//   End Bean Area ***************************    
    

    public Services_Messages_Impl()
        {
        }

    @Override
    public String services_message_send(Messages message)
        {
        message.setMessageDate(GetDate.getDate());
        return getDao_Messages_I().dao_message_send(message);
        }

    @Override
    public List services_message_unread(int userID)
        {
        /**
         * 
         * Have to check that current logged user id 
         * and
         * requested messages user id is same.
         * if not same
         * not allow to read operation.
         * 
         */
        return getDao_Messages_I().dao_message_unread(userID);
        }

    @Override
    public List services_message_read(int userID)
        {
        /**
         * 
         * Have to check that current logged user id 
         * and
         * requested messages user id is same.
         * if not same
         * not allow to read operation.
         * 
         */
        return getDao_Messages_I().dao_message_read(userID);
        }
    
    @Override
    public String services_message_makerRead(int MessageID)
        {
        return getDao_Messages_I().dao_message_makerRead(MessageID);
        }

    public List services_sent_message(int userID)
        {
            return dao_Messages_I.dao_sent_message(userID);
        }
    
        
    }
