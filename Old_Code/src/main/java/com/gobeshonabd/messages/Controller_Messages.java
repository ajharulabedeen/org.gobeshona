package com.gobeshonabd.messages;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.configs.StatusRequestSingleton;
import com.gobeshonabd.pojos.Messages;
import com.gobeshonabd.pojos.StatusRequest;
import com.gobeshonabd.messages.Services_Messages_I;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Messages 
    {
        @Autowired
        private Services_Messages_I bean_services_Messages_I; 
     
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
        
        @RequestMapping( value = "/sendMessage", method = RequestMethod.POST)
        public StatusRequest sendMessage(@RequestBody Messages messages)
          {
            statusRequest.setOperationStatus(bean_services_Messages_I.services_message_send(messages));
            return statusRequest;
          }
        @RequestMapping( value = "/unreadMessagesList/{userID}", method = RequestMethod.GET)
        public List getUnreadMessages(@PathVariable int userID)
          {
            return bean_services_Messages_I.services_message_unread(userID);
          }
        @RequestMapping( value = "/readMessagesList/{userID}", method = RequestMethod.GET)
        public List getReadMessages(@PathVariable int userID)
          {
            return bean_services_Messages_I.services_message_read(userID);
          }
        @RequestMapping( value = "/sentMessages/{userID}", method = RequestMethod.GET)
        public List getSentMessages(@PathVariable int userID)
          {
            return bean_services_Messages_I.services_sent_message(userID);
          }
        
//        have to review. here why list will be returned? 
        @RequestMapping( value = "/makeMessageRead/{messageID}", method = RequestMethod.GET)
        public String makeMessagesRead(@PathVariable int messageID)
          {
            return bean_services_Messages_I.services_message_makerRead(messageID);
          }
        
        @RequestMapping( value = "/availableList_for_block_exception/{userID}", method = RequestMethod.GET)
        public List availableList_for_block_exception(@PathVariable int userID)
          {
              SessionFactory sessionFactory = null;
              Session session = null;

              sessionFactory = HibernateUtil.getSessionFactory();
              session = sessionFactory.openSession();
              String queryNativeMysql_availList_block_exception = ""
                      + "  SELECT DISTINCT"
                      + "      users.user_id,          " //0
                      + "      users.user_first_name,  " //1
                      + "      users.user_last_name,   " //2
                      + "      users.total_up_vote,    " //3
                      + "      users.total_down_vote   " //4
                      + "  FROM"
                      + "      users "
                      + "  INNER JOIN "
                      + "      messages"
                      + "      ON users.user_id = messages.message_sender_id "
                      + "  WHERE users.user_id  "
                      + "      NOT IN  ( SELECT "
                      + "            	message_block.user_who_will_be_blocked "
                      + "              FROM "
                      + "            	message_block "
                      + "              WHERE "
                      + "            	message_block.user_who_will_block = " + userID
                      + "              )"
                      + "  AND users.user_id "
                      + "     NOT IN  ( SELECT "
                      + "            	message_exception.user_who_will_be_made_exception "
                      + "              FROM "
                      + "            	message_exception "
                      + "              WHERE "
                      + "            	message_exception.user_who_will_make_exception = " + userID
                      + "              )"
                      + "  AND"
                      + "      messages.message_receiver_id= " + userID
                      + "  AND"
                      + "    messages.read_status =1 ";

              List availableuser_for_block_exception = new ArrayList();

              List nativeList = session.createSQLQuery(queryNativeMysql_availList_block_exception).list();

              Iterator iterator = nativeList.iterator();
              while (iterator.hasNext())
                {
                  Object[] next = (Object[]) iterator.next();
                  Map map_availUser_block_exception = new HashMap();
                  map_availUser_block_exception.put("userID", next[0]);
                  map_availUser_block_exception.put("userFirstName", next[1]);
                  map_availUser_block_exception.put("userLastName", next[2]);
                  map_availUser_block_exception.put("totalUpVote", next[3]);
                  map_availUser_block_exception.put("totalDownVote", next[4]);
                  availableuser_for_block_exception.add(map_availUser_block_exception);
                }//while (iterator.hasNext())

              session.close();
              sessionFactory.close();

              return availableuser_for_block_exception;
          }
        
    }
