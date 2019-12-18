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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Query;
/**
 *
 * @author Dell-3460
 */
public class DAO_MessageBlocking_Impl implements 
        DAO_MessageBlocking_I, 
        SpringApplicationContextInterface,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {
        @Override
        public String dao_add_To_Block_List(int userID_who_will_block, int userID_who_will_be_blocked )
            {
                MessageBlock messageBlock_block_a_User_obj = (MessageBlock) applicationContext.getBean("pojoMessageBlock");
                messageBlock_block_a_User_obj.setUser_who_will_block(userID_who_will_block);
                messageBlock_block_a_User_obj.setUser_who_will_be_blocked(userID_who_will_be_blocked);
                messageBlock_block_a_User_obj.setDate_of_block(GetDate.getDate());
                return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(messageBlock_block_a_User_obj);
            }
        @Override
        public String dao_remove_From_Block_List(int userID_who_will_unblock, int userID_who_will_be_unblocked)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List getMessageBlocked_User_list = null;
                MessageBlock  messageBlock_obj_to_remove = null;
                
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    Criteria criteria = session.createCriteria(MessageBlock.class);
                    criteria.add(Restrictions.eq("user_who_will_block",userID_who_will_unblock))
                            .add(Restrictions.eq("user_who_will_be_blocked",userID_who_will_be_unblocked));

                    getMessageBlocked_User_list = criteria.list();
                    
                    if(getMessageBlocked_User_list.isEmpty() == false)
                      {
                        messageBlock_obj_to_remove = (MessageBlock) getMessageBlocked_User_list.get(0);
                      }
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting Message block data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting Message block data +++++++++++++++++++++++++++++++++++++++");
                  }

             return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(messageBlock_obj_to_remove);
                
            }
        @Override
        public List dao_see_Who_You_Blocked_list(int userID_see_ur_block_list)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List seeUr_block_list = new ArrayList();
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    
                      String query_blockerUser_list = 
                            "SELECT "
                            + " users.userID, "//0
                            + " users.userFirstName, "//1
                            + " users.userLastName,"//2
                            + " users.joinDate,"//3
                            + " users.skills,"//4
                            + " users.InterestedFields,"//5
                            + " message_block.message_block_id,"//6
                            + " message_block.user_who_will_block,"//7
                            + " message_block.user_who_will_be_blocked,"//8
                            + " message_block.date_of_block, "//9
                            + " users.totalUpVote, "//10
                            + " users.totalDownVote "//11
                            + " FROM "
                            + " MessageBlock message_block , Users users "
                            + " WHERE users.userID = message_block.user_who_will_be_blocked "
                            + " AND message_block.user_who_will_block = "+ userID_see_ur_block_list;
                      
                      Query qry = session.createQuery(query_blockerUser_list );
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
                          map_my_block_list.put("message_block_id", next[6]);
                          map_my_block_list.put("user_who_will_block", next[7]);
                          map_my_block_list.put("user_who_will_be_blocked", next[8]);
                          map_my_block_list.put("date_of_block", next[9]);
                          map_my_block_list.put("totalUpVote", next[10]);
                          map_my_block_list.put("totalDownVote", next[11]);
                          seeUr_block_list.add(map_my_block_list);
                        }// while (iterator.hasNext())
                        
//                    end : new code                    
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting Message block data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting Message block data +++++++++++++++++++++++++++++++++++++++");
                  }

//                return see_ur_block_list;
                return seeUr_block_list;
                
            }
        @Override
        public List dao_see_Who_Blocked_You(int userID_see_who_blocked_u_list)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List see_who_blocked_u_list = null;
                
                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();
                    Criteria criteria = session.createCriteria(MessageBlock.class);
                    criteria.add(Restrictions.eq("user_who_will_be_blocked",userID_see_who_blocked_u_list));
                    criteria.addOrder(Order.desc("message_block_id"));
                    see_who_blocked_u_list = criteria.list();
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting Message block data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting Message block data +++++++++++++++++++++++++++++++++++++++");
                  }
                
                return see_who_blocked_u_list;
            }
        
        
    }

