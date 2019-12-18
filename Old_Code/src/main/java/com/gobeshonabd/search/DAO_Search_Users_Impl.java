/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Users;
import com.gobeshonabd.pojos.Users_Public_View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dell-3460
 */
public class DAO_Search_Users_Impl implements DAO_Search_Users_I
    {
        @Override
        public List<Users_Public_View> dao_search_users ( String searchStringUser, String columnNameUser)
            {
                List userListAfterSearch_obj = getUserSearchList( searchStringUser,columnNameUser);
            
                Iterator iterator = userListAfterSearch_obj.iterator();
                
                List<Users_Public_View> userList = new ArrayList<>();
                
                while (iterator.hasNext())
                  {
                    Object[] userSearch_Obj = (Object[]) iterator.next();
                    
                    userList.add(
                                new Users_Public_View
                                    (
                                        Integer.parseInt(userSearch_Obj[0].toString()) ,// 0. int userID
                                        userSearch_Obj[1].toString(), //    1. String userFirstName,   
                                        userSearch_Obj[2].toString(), //    2. String userLastName
                                        userSearch_Obj[3].toString(), //    3. String InterestedFields
                                        userSearch_Obj[4].toString(), //    4. String joinDate
                                        userSearch_Obj[5].toString(), //    5. String skills
                                        Integer.parseInt(userSearch_Obj[6].toString()), //  6. int communicationInterest
                                        Integer.parseInt(userSearch_Obj[7].toString()), //  7. int totalArticles
                                        Integer.parseInt(userSearch_Obj[8].toString()), //  8. int totalQuestions
                                        Float.parseFloat(userSearch_Obj[9].toString()), //  9. float totalUpVote
                                        Float.parseFloat(userSearch_Obj[10].toString())  //  10. float totalDownVote 
                                    )//Users_Public_View
                            );//userList.add
                    
                  }
//                return userListAfterSearch_obj;
                return userList;
            } //  public List dao_search_users ( String searchString, String columnName)
        
        
        /**
         * This method is done due to make the code sorter.
         * @return use list that match with the requrments.
         */
        private List getUserSearchList(String searchStringUser, String columnNameUser)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List getSearchedUserData = null;

                try
                  {
                    sessionFactory = HibernateUtil.getSessionFactory();
                    session = sessionFactory.openSession();

                    Criteria criteria = session.createCriteria(Users.class);
                    
                    ProjectionList projList = Projections.projectionList();
                        projList.add(Projections.groupProperty("userID"));          //0
                        projList.add(Projections.groupProperty("userFirstName"));   //1
                        projList.add(Projections.groupProperty("userLastName"));    //2
                        projList.add(Projections.groupProperty("InterestedFields"));//3
                        projList.add(Projections.groupProperty("joinDate"));        //4
                        projList.add(Projections.groupProperty("skills"));          //5
                        projList.add(Projections.groupProperty("communicationInterest"));//6
                        projList.add(Projections.groupProperty("totalArticles"));       //7
                        projList.add(Projections.groupProperty("totalQuestions"));      //8
                        projList.add(Projections.groupProperty("totalUpVote"));         //9
                        projList.add(Projections.groupProperty("totalDownVote"));       //10
                    criteria.setProjection(projList);
                    
                    if( columnNameUser.equals("name") )
                      {
                          System.out.println("if( columnNameUser.equals(\"name\") )");
                        Criterion userFirstNameCriterion =   Restrictions.like("userFirstName",searchStringUser,MatchMode.ANYWHERE);
                        Criterion userLastNameCriterion  =   Restrictions.like("userLastName",searchStringUser,MatchMode.ANYWHERE);
                        LogicalExpression searchInNameRestriction = Restrictions.or(userFirstNameCriterion, userLastNameCriterion);                    
                        criteria.add(searchInNameRestriction);
                      }
                    else
                      {
                        Criterion search  =   Restrictions.like(columnNameUser,searchStringUser,MatchMode.ANYWHERE);
                        criteria.add(search);
                      }
                    
                    criteria.addOrder(Order.asc("totalUpVote"))
                            .addOrder(Order.asc("communicationInterest"));
                    
                    getSearchedUserData = criteria.list();
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Error getting user search data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();//may not work, have to test.
                    System.out.println("++++++++++++++++++++++++++++++  end getting user search data +++++++++++++++++++++++++++++++++++++++");
                  }
                
                return getSearchedUserData;
            }
    }
