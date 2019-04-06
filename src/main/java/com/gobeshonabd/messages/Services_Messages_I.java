
package com.gobeshonabd.messages;

import com.gobeshonabd.pojos.Messages;
import java.util.List;


public interface Services_Messages_I
    {
        public String services_message_send(Messages message);
        public List services_message_unread(int userID);
        public List services_message_read(int userID);
        public List services_sent_message(int userID);
        String services_message_makerRead(int MessageID); 
    }
