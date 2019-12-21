package org.gobeshona.articles;

import org.gobeshona.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import org.gobeshona.configs.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO_Articles_Comment_Impl
        implements 
        DAO_Articles_Comment_I,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_Articles_Comment_Impl()
      {
        
      }

    @Override
//    public String dao_postComment(ArticlesComments_Insert articlesCommentsToPost)
    public ArticlesComments_Insert dao_postComment(ArticlesComments_Insert articlesCommentsToPost)
      {
//          System.out.println("\n public String dao_postComment(ArticlesComments_Insert articlesCommentsToPost) \n");
//        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(articlesCommentsToPost);
      
        ArticlesComments_Insert articlesComments_Insert_to_return = null;
        
        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            
            Transaction tx = session.beginTransaction();
            session.save(articlesCommentsToPost);
            tx.commit();
            
            articlesComments_Insert_to_return = articlesCommentsToPost;
          } 
        catch (Exception e)
          {
            System.out.println("\n\n Article Comments insert Error : " + e.getClass());
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } 
        finally
          {
            session.close();
            factory.close();
            System.out.println("++++++++++++++++++++++++++++++  Article Comments  insert Final +++++++++++++++++++++++++++++++++++++++");
          }
        return articlesComments_Insert_to_return;
      } //public ArticlesComments_Insert dao_postComment(ArticlesComments_Insert articlesCommentsToPost)

    @Override
    public String dao_deleteComment(ArticlesComments articlesCommentsToDelete)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(articlesCommentsToDelete);
      } //public String dao_deleteComment(ArticlesComments articlesCommentsToDelete)

    @Override
    public String dao_updateComment(ArticlesComments articlesCommentsToUpdate)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(articlesCommentsToUpdate);
      } //public String dao_updateComment(ArticlesComments articlesCommentsToUpdate)

    @Override
    public ArticlesComments dao_readSpecificComment(int specificCommentID)
      {
        SessionFactory sessionFactory = null;
        Session session = null;
        Object o = null;
        ArticlesComments articlesCommentsInfo = null;
        ArticlesComments articlesCommentsToShow = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            o = session.load(ArticlesComments.class, new Integer(specificCommentID));
            
            articlesCommentsInfo = (ArticlesComments) o;
            
            articlesCommentsToShow = new ArticlesComments(
                    articlesCommentsInfo.getCommentId(), 
                     articlesCommentsInfo.getUserID(), 
                     articlesCommentsInfo.getCommentDate(), 
                     articlesCommentsInfo.getCommentUpVote(), 
                     articlesCommentsInfo.getCommentDownVote(), 
                     articlesCommentsInfo.getCommentContent() 
            );
          } 
        catch (Exception e)
          {
              System.out.println("\n Error happened in reading specific Article Comment data for details.\n");
              e.printStackTrace();
              System.out.println("\n\n");
          }
        finally
          {
            //prepared for GC.
            o = null;
            articlesCommentsInfo = null;
            
            session.close();
            sessionFactory.close();
          }
        return articlesCommentsToShow;
      }//    public ArticlesComments dao_readSpecificComment(int specificCommentID)
    
    }
