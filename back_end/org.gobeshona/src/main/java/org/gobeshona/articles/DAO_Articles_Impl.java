package org.gobeshona.articles;

import org.gobeshona.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import static org.gobeshona.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl.bean_generel_Insert_Update_Delete_SelectAll_I;
import org.gobeshona.configs.HibernateUtil;
import org.gobeshona.pojos.Articles;
import org.gobeshona.pojos.Articles_Insert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO_Articles_Impl implements 
        DAO_Articles_I, 
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_Articles_Impl()
      {

      }

    @Override
//    public String dao_postArticle(Articles_Insert articleToPost)
    public Articles_Insert dao_postArticle(Articles_Insert articleToPost)
      {
//        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(articleToPost);
        String dataDeleteStatus = "public String dao_Generel_Delete(Object objectToDelete)";        
        Articles_Insert articles_Insert_to_return = null;
        
        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            
            Transaction tx = session.beginTransaction();
            session.save(articleToPost);
            tx.commit();
            
            articles_Insert_to_return = articleToPost;
          } 
        catch (Exception e)
          {
            dataDeleteStatus = "failDelete";
            System.out.println("\n\n Article insert Error : " + e.getClass());
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } 
        finally
          {
            session.close();
            factory.close();
            System.out.println("++++++++++++++++++++++++++++++  Article insert Final +++++++++++++++++++++++++++++++++++++++");
          }

        return articles_Insert_to_return;
      }//public Articles_Insert dao_postArticle(Articles_Insert articleToPost)

    @Override
    public String dao_deleteArticle(Articles articleToDelete)
      {
        /**
         * Here this below line will return "successDelete" string, if Delete
         * done successfully, else return "failDelete" string, if any failure
         * occurs to Delete.
         */
       return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(articleToDelete);
      }//public String dao_deleteArticle(Articles articleToDelete)

    @Override
    public String dao_updateArticle(Articles articleToUpdate)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(articleToUpdate);
      }//public String dao_updateArticle(Articles articleToUpdate)
    
    
    @Override
    public List dao_readAllArticlesWithOutContent()
      {
          String query = "Select "
                  + "     articles.articleID, "//0
                  + "     articles.userID_articleByUser, "//1
                  + "     articles.articleSubject, "//2
                  + "     articles.articleUpvote, "//3
                  + "     articles.articleDownvote, "//4
                  + "     articles.articleDate, "//5
                  + "     articles.articleType,"//6
                  + "     user.userID, "//7
                  + "     user.userFirstName, "//8
                  + "     user.userLastName, "//9
                  + "     user.joinDate, "//10
                  + "     user.communicationInterest,"//11
                  + "     user.totalUpVote, "//12
                  + "     user.totalDownVote "//13
                  + " from "
                  + "    Articles_Insert articles, Users user "
                  + " where "
                  + "    user.userID = articles.userID_articleByUser";

          SessionFactory sessionFactory = null;
          Session session = null;

          sessionFactory = HibernateUtil.getSessionFactory();
          session = sessionFactory.openSession();

          Query qry = session.createQuery(query);
          List list = qry.list();
          List articleWithOutContent_list = new ArrayList();

          Iterator iterator = list.iterator();
          while (iterator.hasNext())
              {
                Object[] next = (Object[]) iterator.next();
                Map map = new HashMap();
                map.put("articleID",next[0].toString());//0
                map.put("userID_articleByUser",next[1].toString());//1
                map.put("articleSubject",next[2].toString());//2
                map.put("articleUpvote",next[3].toString());//3
                map.put("articleDownvote",next[4].toString());//4
                map.put("articleDate",next[5].toString());//5
                map.put("articleType",next[6].toString());//6
                map.put("userID",next[7].toString());//7
                map.put("userFirstName",next[8].toString());//8
                map.put("userLastName",next[9].toString());//9
                map.put("joinDate",next[10].toString());//10
                map.put("communicationInterest",next[11].toString());//11
                map.put("totalUpVote",next[12].toString());//12
                map.put("totalDownVote",next[13].toString());//13
                articleWithOutContent_list.add(map);
              }

          return articleWithOutContent_list;
      }//public List dao_readAllArticlesWithOutContent()

    
    @Override
    public List dao_readSpecificArticle(int articleID)
      {
          /**
           * 
           * Same problem here, lazy loading problem, if the session closed. 
           * Have to solve later.
           * 
           */
          String readSpecificArticle = " from Articles_Insert a where a.articleID = " + articleID;
          
          SessionFactory factory = HibernateUtil.getSessionFactory();
          Session session = factory.openSession();
          Query qry = session.createQuery(readSpecificArticle);
          List l = qry.list();
          session.close();//Here is problem, if Session is closed then unable to back data.
          factory.close();
          return l;
        
//        SessionFactory sessionFactory = null;
//        Session session = null;
//        Object o = null;
//        Articles articlesInfo = null;
//        Articles articleToShow = null;
//
//        try
//          {
//            sessionFactory = HibernateUtil.getSessionFactory();
//            session = sessionFactory.openSession();
//            o = session.load(Articles.class, new Integer(articleID));
//            
//            articlesInfo = (Articles) o;
//            
//            articleToShow = new Articles(
//                    articlesInfo.getArticleID(), 
//                    articlesInfo.getArticleSubject(), 
//                    articlesInfo.getArticleUpvote(),
//                    articlesInfo.getArticleDownvote(),
//                    articlesInfo.getArticleDate(), 
//                    articlesInfo.getArticleContent(), 
//                    articlesInfo.getArticleType(), 
//                    articlesInfo.getArticlesComments()
//            ); 
//          } 
//        catch (Exception e)
//          {
//              System.out.println("\n Error happened in reading specific Article data for details.\n");
//              e.printStackTrace();
//              System.out.println("\n\n");
//          }
//        finally
//          {
//            articlesInfo = null;
//            session.close();
//            sessionFactory.close();
//          }
//        return articleToShow;
      }//End : public List dao_readSpecificArticle(int articleID)
    }//class
