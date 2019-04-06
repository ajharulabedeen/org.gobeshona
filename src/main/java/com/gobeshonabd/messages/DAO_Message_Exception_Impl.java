/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.messages;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.pojos.MessageBlock;
import com.gobeshonabd.pojos.MessageException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dell-3460
 */
public class DAO_Message_Exception_Impl 
        implements 
        DAO_Message_Exception_I,
        SpringApplicationContextInterface,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {
        @Override
        public String dao_add_to_exception_list(int user_who_will_make_exception, int user_who_will_be_made_exception)
            {
                MessageException messageException_obj_add_user_to_exception = (MessageException) applicationContext.getBean("pojoMessageException");
                messageException_obj_add_user_to_exception.setUser_who_will_make_exception(user_who_will_make_exception);
                messageException_obj_add_user_to_exception.setUser_who_will_be_made_exception(user_who_will_be_made_exception);
                messageException_obj_add_user_to_exception.setDate_making_exception(GetDate.getDate());
                return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(messageException_obj_add_user_to_exception);
            }
        @Override
        public String dao_remove_from__exception_list(int user_who_will_make_unexception, int user_who_will_be_made_unexception)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List getMessageException_User_list = null;
                MessageException  messageException_obj_to_remove = null;
                
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    
                    Criteria criteria = session.createCriteria(MessageException.class);
                    criteria.add(Restrictions.eq("user_who_will_make_exception",user_who_will_make_unexception))
                            .add(Restrictions.eq("user_who_will_be_made_exception",user_who_will_be_made_unexception));

                    getMessageException_User_list = criteria.list();
                    
                    if(getMessageException_User_list.isEmpty() == false)
                      {
                        messageException_obj_to_remove = (MessageException) getMessageException_User_list.get(0);
                      }
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting Message Exception data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting Message Exception data +++++++++++++++++++++++++++++++++++++++");
                  }

                return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(messageException_obj_to_remove);
            }
        /**
         * List of people who were made exception by me.
         * @param userID_see_ur_exception_list the id of a user who wanna see her exception list.
         * @return 
         */
        @Override
        public List dao_see_who_you_made_exception(int userID_see_ur_exception_list)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List see_ur_exception_list = null;
                
                List seeUr_exception_list = new ArrayList();
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    
                      String query_myException_list = 
                            "SELECT distinct  "
                            + " users.userID, "//0
                            + " users.userFirstName, "//1
                            + " users.userLastName,"//2
                            + " users.joinDate,"//3
                            + " users.skills,"//4
                            + " users.InterestedFields,"//5
                            + " message_exception.message_exception_id,"//6
                            + " message_exception.user_who_will_make_exception,"//7
                            + " message_exception.user_who_will_be_made_exception,"//8
                            + " message_exception.date_making_exception, "//9
                            + " users.totalUpVote, "//10
                            + " users.totalDownVote "//11
                            + " FROM "
                            + " MessageException message_exception , Users users "
                            + " WHERE users.userID = message_exception.user_who_will_be_made_exception "
                            + " AND message_exception.user_who_will_make_exception = "+ userID_see_ur_exception_list;
                      
                      Query qry = session.createQuery(query_myException_list );
                      List list = qry.list();
                    
                    
//                    start : new code
                      Iterator iterator = list.iterator();
                      while (iterator.hasNext())
                        {
                          Object[] next = (Object[]) iterator.next();
                          Map map_my_block_list = new HashMap();
                          map_my_block_list.put("userID", next[0]);
                          map_my_block_list.put("userFirstName", next[1]);
                          map_my_block_list.put("userLastName", next[2]);
                          map_my_block_list.put("joinDate", next[3]);
                          map_my_block_list.put("skills", next[4]);
                          map_my_block_list.put("InterestedFields", next[5]);
                          map_my_block_list.put("message_exception_id", next[6]);
                          map_my_block_list.put("user_who_will_make_exception", next[7]);
                          map_my_block_list.put("user_who_will_be_made_exception", next[8]);
                          map_my_block_list.put("date_making_exception", next[9]);
                          map_my_block_list.put("totalUpVote", next[10]);
                          map_my_block_list.put("totalDownVote", next[11]);
                          seeUr_exception_list.add(map_my_block_list);
                        }// while (iterator.hasNext())
                        
//                    end : new code                    
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting Message Exception data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting Message Exception data +++++++++++++++++++++++++++++++++++++++");
                  }

                return seeUr_exception_list;
                
            }
        @Override
        public List dao_see_who_made_you_exception(int userID_see_who_made_you_exception)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List see_who_made_u_exception_in_list = null;
                
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    Criteria criteria = session.createCriteria(MessageException.class);
                    criteria.add(Restrictions.eq("user_who_will_be_made_exception",userID_see_who_made_you_exception));
                    criteria.addOrder(Order.desc("message_exception_id"));
                    see_who_made_u_exception_in_list = criteria.list();
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting who made me exceptin data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting who made me exceptin data +++++++++++++++++++++++++++++++++++++++");
                  }
                
                return see_who_made_u_exception_in_list;
            }
    }
