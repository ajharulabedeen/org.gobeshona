/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Articles_Concise_View;
import com.gobeshonabd.pojos.Articles_Insert;
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
public class DAO_Search_Article_Impl implements DAO_Search_Article_I
    {
        @Override
        public List dao_search_article(String searchStringArticle, String searchColumnNameArticle)
            {
                List articleListAferSearch = getArticleSearchList(searchStringArticle, searchColumnNameArticle);
             
                List articleList = new ArrayList();
                
                Iterator iteratorArticle = articleListAferSearch.iterator();
                
                while (iteratorArticle.hasNext())
                  {
                    Object[] articleSearch_obj = (Object[]) iteratorArticle.next();
                    
                    //      0   Articles_Concise_View > int articleID;              Articles_Insert > int   articleID;
                            int     articleID = Integer.parseInt(articleSearch_obj[0].toString());
                    
                    //      1   Articles_Concise_View > String  articleSubject;     Articles_Insert > String    articleSubject;
                            String  articleSubject = articleSearch_obj[1].toString();
                            
                    //      2   Articles_Concise_View > int     articleUpvote;      Articles_Insert > int   articleUpvote;
                            int     articleUpvote = Integer.parseInt(articleSearch_obj[2].toString()); 
                            
                    //      3   Articles_Concise_View > int     articleDownvote;    Articles_Insert > int   articleDownvote;
                            int     articleDownvote = Integer.parseInt(articleSearch_obj[3].toString()); 
                            
                    //      4   Articles_Concise_View > String  articleDate;        Articles_Insert > String    articleDate;
                            String  articleDate = articleSearch_obj[4].toString();
                            
                    //      5   Articles_Concise_View > String  articleType;        Articles_Insert > String    articleType;
                            String  articleType  = articleSearch_obj[5].toString();
                            
                    //      6   Articles_Concise_View > int userID_questionsAskedByUse  Articles_Insert > int       userID_articleByUser;
                            int userID_questionsAskedByUse  = Integer.parseInt(articleSearch_obj[6].toString());
                            
                    articleList.add(
                            new Articles_Concise_View(
                                    //This has copied from the class 
                                    articleID,      //0  int articleID,
                                    articleSubject, //1  String articleSubject
                                    articleUpvote,  //2  int articleUpvote
                                    articleDownvote,//3  int articleDownvote
                                    articleDate,    //4  String articleDate
                                    articleType,    //5  String articleType
                                    userID_questionsAskedByUse//6int userID
                                    
                                    )//new Articles_Concise_View(
                            );//articleList.add(
               
                  }
                
                return articleList;
            }
        static private List getArticleSearchList(String searchStringArticle, String columnNameArticle)
            {
                SessionFactory sessionFactory = null;
                Session session = null;
                List getSearchedArticleData = null;

                try
                  {
                    sessionFactory  = HibernateUtil.getSessionFactory();
                    session         = sessionFactory.openSession();

                    Criteria criteria = session.createCriteria(Articles_Insert.class);
                    
                    ProjectionList projList = Projections.projectionList();
                        projList.add(Projections.groupProperty("articleID"));       //0     private int     articleID;
                        projList.add(Projections.groupProperty("articleSubject"));  //1     private String  articleSubject;
                        projList.add(Projections.groupProperty("articleUpvote"));   //2     private int     articleUpvote;
                        projList.add(Projections.groupProperty("articleDownvote")); //3     private int     articleDownvote;
                        projList.add(Projections.groupProperty("articleDate"));     //4     private String  articleDate;
                        projList.add(Projections.groupProperty("articleType"));     //5     private String  articleType;
                        projList.add(Projections.groupProperty("userID_articleByUser"));//6 private int userID_articleByUser;
                    criteria.setProjection(projList);
                    
                    Criterion search  =   Restrictions.like(columnNameArticle,searchStringArticle,MatchMode.ANYWHERE);
                    criteria.add(search);
                    
                    criteria.addOrder(Order.asc("articleUpvote"));
                    
                    getSearchedArticleData = criteria.list();
                      System.out.println("\n++++++++++++ getSearchedArticleData = criteria.list();\n"+getSearchedArticleData.size());
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
                
                return getSearchedArticleData;
            }
    }
