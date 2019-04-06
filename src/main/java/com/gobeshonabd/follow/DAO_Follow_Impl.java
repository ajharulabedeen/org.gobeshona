package com.gobeshonabd.follow;

import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import com.gobeshonabd.pojos.Follow;
import java.util.List;
import com.gobeshonabd.configs.HibernateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * To get the list who are following-------
 *      Who u are following, to get that list
 *          select from ColumnA, u will get the list of ID who u are following.
 * To get the list who following u-------
 *      Who u are following, to get that list
 *          select from ColumnB, u will get the list of ID who are following U.
 */



public class DAO_Follow_Impl 
        implements 
        DAO_Follow_I,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_Follow_Impl()
        {
        }
    
    @Override
    public String dao_addFollower(Follow follow)
        {
            return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(follow);
        }

    @Override
    public String dao_removeFollower(Follow follow)
        {
            return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(follow);
        }

    /**
             * 
             * Have to use try..catch.
             * 
             * To get the list who are following-------
             *      Who u are following, to get that list
             *          select from ColumnA, u will get the list of ID who u are following.
             *          whom i follow.
             * Have to test session close.
             * 
             */
    @Override
    public List dao_listColumnA(int userID)
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            String query_whom_I_follow = " "
                    + "select "
                    + "     user.userID, "//0
                    + "     user.userFirstName, "//1
                    + "     user.userLastName,"//2
                    + "     user.InterestedFields,"//3
                    + "     user.joinDate,"//4
                    + "     user.skills,"//5
                    + "     user.communicationInterest, "//6
                    + "     user.totalArticles, "//7
                    + "     user.totalQuestions, "//8
                    + "     user.totalUpVote, "//9
                    + "     user.totalDownVote "//10
                    + " from "
                    + "     Users user, Follow f "
                    + " where"
                    + "     user.userID = f.columnA "
                    + "     and f.columnA = " + userID;
                  
                   
            Query query = session.createQuery(query_whom_I_follow);
            List uFollowingList_list = query.list();
            List uFollowingList_list_toshow = new ArrayList();
            
            
            //                    start : new code
                      Iterator iterator = uFollowingList_list.iterator();
                      while (iterator.hasNext())
                        {
                          Object[] next = (Object[]) iterator.next();
                          Map map_whol_i_list = new HashMap();
                          map_whol_i_list.put("userID", next[0]);
                          map_whol_i_list.put("userFirstName", next[1]);
                          map_whol_i_list.put("userLastName", next[2]);
                          map_whol_i_list.put("InterestedFields", next[3]);
                          map_whol_i_list.put("joinDate", next[4]);
                          map_whol_i_list.put("skills", next[5]);
                          map_whol_i_list.put("communicationInterest", next[6]);
                          map_whol_i_list.put("totalArticles", next[7]);
                          map_whol_i_list.put("totalQuestions", next[8]);
                          map_whol_i_list.put("totalUpVote", next[9]);
                          map_whol_i_list.put("totalDownVote", next[10]);
                          uFollowingList_list_toshow.add(map_whol_i_list);
                        }// while (iterator.hasNext())
            
            session.close();
            sessionFactory.close();
            return uFollowingList_list_toshow;
        }

    /**
             * 
             * Have to use try..catch.
             * 
            * To get the list who following u------- Who u are following, to
             * get that list select from ColumnB, u will get the list of ID who
             * are following U.
             * 
             * Have to test session close.
             */
    @Override
    public List dao_listColumnB(int userID)
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            String query_whom_follow_me = " "
                    + "select "
                    + "     user.userID, "//0
                    + "     user.userFirstName, "//1
                    + "     user.userLastName,"//2
                    + "     user.InterestedFields,"//3
                    + "     user.joinDate,"//4
                    + "     user.skills,"//5
                    + "     user.communicationInterest, "//6
                    + "     user.totalArticles, "//7
                    + "     user.totalQuestions, "//8
                    + "     user.totalUpVote, "//9
                    + "     user.totalDownVote "//10
                    + " from "
                    + "     Users user, Follow f "
                    + " where"
                    + "     user.userID = f.columnA "
                    + "     and f.columnB = " + userID;
                  
                   
            Query query = session.createQuery(query_whom_follow_me);
            List uFollowingList_list = query.list();
            List whoFollow_me_List_list_toshow = new ArrayList();
            
            
            //                    start : new code
                      Iterator iterator = uFollowingList_list.iterator();
                      while (iterator.hasNext())
                        {
                          Object[] next = (Object[]) iterator.next();
                          Map map_whol_i_list = new HashMap();
                          map_whol_i_list.put("userID", next[0]);
                          map_whol_i_list.put("userFirstName", next[1]);
                          map_whol_i_list.put("userLastName", next[2]);
                          map_whol_i_list.put("InterestedFields", next[3]);
                          map_whol_i_list.put("joinDate", next[4]);
                          map_whol_i_list.put("skills", next[5]);
                          map_whol_i_list.put("communicationInterest", next[6]);
                          map_whol_i_list.put("totalArticles", next[7]);
                          map_whol_i_list.put("totalQuestions", next[8]);
                          map_whol_i_list.put("totalUpVote", next[9]);
                          map_whol_i_list.put("totalDownVote", next[10]);
                          whoFollow_me_List_list_toshow.add(map_whol_i_list);
                        }// while (iterator.hasNext())
            
            session.close();
            sessionFactory.close();
            return whoFollow_me_List_list_toshow;
        }

//start... no Need************** Follower will be counted in the font end by NG 
//    @Override
//    public int dao_countFollower(int userID)
//        {
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            Criteria criteria = session.createCriteria(Follow.class);
//            criteria.add(Restrictions.eq("columnB", new Integer(userID)));
//            List uFollowingList = criteria.list();
//            session.close();
//            sessionFactory.close();
//        }
//End..... no Need************** Follower will be counted in the font end by NG
    }
