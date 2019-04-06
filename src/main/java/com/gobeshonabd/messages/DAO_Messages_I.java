package com.gobeshonabd.messages;

import com.gobeshonabd.pojos.Messages;
import java.util.List;

public interface DAO_Messages_I
    {
        public String dao_message_send(Messages message);
        public List dao_message_unread(int userID);
        public List dao_message_read(int userID);
        public List dao_sent_message(int userID);
        String dao_message_makerRead(int MessageID); 
    }
