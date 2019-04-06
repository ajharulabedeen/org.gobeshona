package com.gobeshonabd.messages;

import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Messages;
import com.gobeshonabd.pojos.Messages_With_Uname;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import static sun.misc.ClassFileTransformer.add;

public class DAO_Messages_Impl implements DAO_Messages_I,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    @Override
    public String dao_message_send(Messages message)
        {
            return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(message);
        }
    
    /**
         * 
         * Try..catch left.
         * think no need as closing of bracket will destroy the factory 
         * and the session.
         * 
         * Have to test session close.
         * 
         */
    @Override
    public List dao_message_read(int userID)
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
                    String qryString = " SELECT "
                    + " users.userID, "//0
                    + " users.userFirstName, "//1
                    + " users.userLastName, "//2
                    + " messages.MessageID, "//3
                    + " messages.MessageDate, "//4
                    + " messages.messageSenderID, "//5
                    + " messages.messageReceiverID, "//6
                    + " messages.message, "//7
                    + " messages.readStatus,"//8
                    + " messages.subject "//9
                    + ""
                    + " FROM Messages messages ,Users users "
                    + " where messages.messageSenderID = users.userID "
                    + " and "
                    + " messages.readStatus = 1  "
                    + " and "
                    + " messages.messageReceiverID = "+ userID 
                    + " order by messages.MessageID desc ";
            
            Query qry = session.createQuery(qryString );
            List list = qry.list();
            List message_read_list = new ArrayList();
            
                Iterator iterator = list.iterator();
                while (iterator.hasNext())
                  {
                    Object[] next = (Object[]) iterator.next();
                    
                    Messages_With_Uname messages_With_Uname = new Messages_With_Uname(
                            Integer.parseInt(next[0].toString()),//0 int userID, 
                            next[1].toString(),//1 String userFirstName, 
                            next[2].toString(),//2 String userLastName, 
                            Integer.parseInt(next[3].toString()),//3 int MessageID, 
                            next[4].toString(), //4 String MessageDate, 
                            Integer.parseInt(next[5].toString()), //5 int messageSenderID, 
                            Integer.parseInt(next[6].toString()),//6 int messageReceiverID,
                            next[7].toString(),//7 String message 
                            Integer.parseInt(next[8].toString()),//8 int readStatus
                            next[9].toString()//9 String subject
                    );
                    message_read_list.add(messages_With_Uname);
                  }//while (iterator.hasNext())
            
            session.close();
            sessionFactory.close();
            System.out.println("\npublic List dao_message_read(int userID)\n");
            return message_read_list;
        }

    /**
         * 
         * Try..catch left.
         * think no need as closing of bracket will destroy the factory 
         * and the session.
         * 
         * Have to test session close.
         * 
         */
    @Override
    public List dao_message_unread(int userID)
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            String qryString = " SELECT "
                    + " users.userID, "//0
                    + " users.userFirstName, "//1
                    + " users.userLastName, "//2
                    + " messages.MessageID, "//3
                    + " messages.MessageDate, "//4
                    + " messages.messageSenderID, "//5
                    + " messages.messageReceiverID, "//6
                    + " messages.message, "//7
                    + " messages.readStatus,  "//8
                    + " messages.subject "//9
                    + ""
                    + " FROM Messages messages ,Users users "
                    + " where messages.messageReceiverID = users.userID "
                    + " and "
                    + " messages.readStatus = 0  "
                    + " and "
                    + " messages.messageReceiverID = "+ userID 
                    + " order by messages.MessageID desc ";
            
            Query qry = session.createQuery(qryString );
            List list = qry.list();
            List message_unread_list = new ArrayList();
            
                Iterator iterator = list.iterator();
                while (iterator.hasNext())
                  {
                    Object[] next = (Object[]) iterator.next();
                    
                    Messages_With_Uname messages_With_Uname = new Messages_With_Uname(
                            Integer.parseInt(next[0].toString()),//0 int userID, 
                            next[1].toString(),//1 String userFirstName, 
                            next[2].toString(),//2 String userLastName, 
                            Integer.parseInt(next[3].toString()),//3 int MessageID, 
                            next[4].toString(), //4 String MessageDate, 
                            Integer.parseInt(next[5].toString()), //5 int messageSenderID, 
                            Integer.parseInt(next[6].toString()),//6 int messageReceiverID,
                            next[7].toString(),//7 String message 
                            Integer.parseInt(next[8].toString()),//8 int readStatus
                            next[9].toString()//9 String subject
                    );
                    message_unread_list.add(messages_With_Uname);
                  }//while (iterator.hasNext())

            session.close();
            sessionFactory.close();
            return message_unread_list;
        }

    public List dao_sent_message(int userID)
        {
             SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            String qryString = " SELECT "
                    + " users.userID, "//0
                    + " users.userFirstName, "//1
                    + " users.userLastName, "//2
                    + " messages.MessageID, "//3
                    + " messages.MessageDate, "//4
                    + " messages.messageSenderID, "//5
                    + " messages.messageReceiverID, "//6
                    + " messages.message, "//7
                    + " messages.readStatus,  "//8
                    + " messages.subject "//9
                    + " "
                    + " FROM Messages messages , Users users "
                    + " where messages.messageSenderID = " + userID
                    + " and "
                    + " messages.messageReceiverID = users.userID "
                    + " order by messages.MessageID desc";
            
            Query qry = session.createQuery(qryString );
            List list = qry.list();
            List message_unread_list = new ArrayList();
            
                Iterator iterator = list.iterator();
                while (iterator.hasNext())
                  {
                    Object[] next = (Object[]) iterator.next();
                    
                    Messages_With_Uname messages_With_Uname = new Messages_With_Uname(
                            Integer.parseInt(next[0].toString()),//0 int userID, 
                            next[1].toString(),//1 String userFirstName, 
                            next[2].toString(),//2 String userLastName, 
                            Integer.parseInt(next[3].toString()),//3 int MessageID, 
                            next[4].toString(), //4 String MessageDate, 
                            Integer.parseInt(next[5].toString()), //5 int messageSenderID, 
                            Integer.parseInt(next[6].toString()),//6 int messageReceiverID,
                            next[7].toString(),//7 String message 
                            Integer.parseInt(next[8].toString()),//8 int readStatus
                             next[9].toString()//9 String subject
                            
                    );
                    message_unread_list.add(messages_With_Uname);
                  }//while (iterator.hasNext())

            session.close();
            sessionFactory.close();
            return message_unread_list;
        }
    
     /**
         * Lazy loading problem.
         * 
         * Try..catch left.
         * think no need as closing of bracket will destroy the factory 
         * and the session.
         * 
         * Have to test session close.
         * 
         */
    @Override
    public String dao_message_makerRead(int MessageID)
        {
       
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            Criteria criteria = session.createCriteria(Messages.class);
            criteria.add(Restrictions.eq("MessageID", new Integer(MessageID)));
            
            List message_makeRead_list = criteria.list();
            
            Messages messages = (Messages) message_makeRead_list.get(0);
            messages.setReadStatus(1);
            //Send for updation.
            return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(messages);
        }
        
    }
