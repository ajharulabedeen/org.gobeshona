/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswer_View_Summury;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dell-3460
 */
public class DAO_Search_QuestionAndAnswar_Impl implements DAO_Search_QuestionAndAnswar_I
    {
        @Override
        public List dao_search_QuestionAndAnswar(String searchStringQuestionAndAnswar, String searchColumnNameQuestionAndAnswar)
            {
                //This is the order in QuestionAndAnswar_Inser Class.
                    //    0 private int     questionID;
                    //    1 private String  questionDate ;
                    //    2 private int     quesionUpVote ;
                    //    3 private int     quesionDownVote ;
                    //    4 private String  question ;
                    //    5 private int     answerID;
                    //    6 private String  questionType ;
                    //    7 private int     userID_questionsAskedByUser;
            
                List list_SearchedQuestionAndAnswarData =getQuestionAndAnswarSearchList(searchStringQuestionAndAnswar, searchColumnNameQuestionAndAnswar);
                   
                List search_QuestionAndAnswar = new ArrayList();
                    
                Iterator iteratorQuestionAndAnswar = list_SearchedQuestionAndAnswarData.iterator();
                    
                while (iteratorQuestionAndAnswar.hasNext())
                  {
                    Object[] questionAndAnswar_obj = (Object[]) iteratorQuestionAndAnswar.next();
                    
                    //    0 private int     questionID;
                        int  questionID      = Integer.parseInt(questionAndAnswar_obj[0].toString());
                    //    1 private String  questionDate ;
                        String  questionDate = questionAndAnswar_obj[1].toString() ;
                    //    2 private int     quesionUpVote ;
                        int quesionUpVote    = Integer.parseInt(questionAndAnswar_obj[2].toString());
                    //    3 private int     quesionDownVote ;
                        int quesionDownVote  = Integer.parseInt(questionAndAnswar_obj[3].toString());
                    //    4 private String  question ;
                        String  question    = questionAndAnswar_obj[4].toString();
                    //    5 private int     answerID;
                        int   answerID      = Integer.parseInt(questionAndAnswar_obj[5].toString());
                    //    6 private String  questionType ;
                        String questionType = questionAndAnswar_obj[6].toString();;
                    //    7 private int     userID_questionsAskedByUser;
                        int userID_questionsAskedByUser = Integer.parseInt(questionAndAnswar_obj[7].toString());
                        
                        search_QuestionAndAnswar.add(
                                new QuestionAndAnswer_View_Summury
                                    (
                                    //these are the order off QuestionAndAnswer_View_Summury class.
                                        questionID,//int     questionID, //0
                                        userID_questionsAskedByUser,//int     userID,     //1
                                        questionDate,//String  questionDate, //2
                                        questionType,//String  questionType, //3
                                        question,//String  question, //4
                                        quesionUpVote,//int     quesionUpVote,//5 
                                        quesionDownVote//int     quesionDownVote //6
                                    )//new QuestionAndAnswer_View_Summury
                        );//search_QuestionAndAnswar.add(
                    
                  }//while (iteratorQuestionAndAnswar.hasNext())
                
                return search_QuestionAndAnswar;
            }
        
        
        static private List getQuestionAndAnswarSearchList(String searchStringArticle, String columnNameArticle)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List list_SearchedQuestionAndAnswarData = null;

                try
                  {
                    sessionFactory  = HibernateUtil.getSessionFactory();
                    session         = sessionFactory.openSession();

                    Criteria criteria = session.createCriteria(QuestionAndAnswer_Insert.class);
                    
                    ProjectionList projList = Projections.projectionList();
                        projList.add(Projections.groupProperty("questionID"));      //    0 private int     questionID;
                        projList.add(Projections.groupProperty("questionDate"));    //    1 private String  questionDate ;
                        projList.add(Projections.groupProperty("quesionUpVote"));   //    2 private int     quesionUpVote ;
                        projList.add(Projections.groupProperty("quesionDownVote")); //    3 private int     quesionDownVote ;
                        projList.add(Projections.groupProperty("question"));        //    4 private String  question ;
                        projList.add(Projections.groupProperty("answerID"));        //    5 private int     answerID;
                        projList.add(Projections.groupProperty("questionType"));        //    6 private String  questionType ;
                        projList.add(Projections.groupProperty("userID_questionsAskedByUser"));//7 private int     userID_questionsAskedByUser;
                    criteria.setProjection(projList);
                    
                    Criterion search  =   Restrictions.like(columnNameArticle,searchStringArticle,MatchMode.ANYWHERE);
                    criteria.add(search);
                    criteria.addOrder(Order.asc("quesionUpVote"));
                    list_SearchedQuestionAndAnswarData = criteria.list();
                  } 
                catch (Exception e)
                  {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++ Error getting article search data ++++++++++++++++++++++++++++++++++++++++");
                  } 
                finally
                  {
                    session.close();
                    sessionFactory.close();
                    System.out.println("++++++++++++++++++++++++++++++  end getting article search data +++++++++++++++++++++++++++++++++++++++");
                  }
                
                return list_SearchedQuestionAndAnswarData;
            }
        
    }
