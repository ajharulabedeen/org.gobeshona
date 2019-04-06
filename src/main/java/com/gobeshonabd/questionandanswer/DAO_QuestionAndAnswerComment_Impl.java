package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO_QuestionAndAnswerComment_Impl 
        implements 
        DAO_QuestionAndAnswerComment_I, 
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_QuestionAndAnswerComment_Impl()
      {
      
      }

    @Override
    public QuestionAndAnswerComment_Insert dao_postQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentPost)
      {
        QuestionAndAnswerComment_Insert questionAndAnswerComment_Insert_obj_for_return = null;
      
        String dataInsertionStatus = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession(); 
            Transaction tx = session.beginTransaction();    
            session.save(questionAndAnswerCommentPost);
            tx.commit();
            dataInsertionStatus = Integer.toString(questionAndAnswerCommentPost.getUserID());
            questionAndAnswerComment_Insert_obj_for_return = questionAndAnswerCommentPost;
          } 
        catch (Exception e)
          {
            System.out.println("\n\n QuestionAndAnswerComment Insertion Error : " + e.getClass());
            System.out.println();
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ QuestionAndAnswerComment Insert error ++++++++++++++++++++++++++++++++++++++++");
          } 
        finally
          {
            session.close();
            sessionFactory.close();
            System.out.println("++++++++++++++++++++++++++++++  QuestionAndAnswerComment Insert Finished+++++++++++++++++++++++++++++++++++++++");
          }
        return questionAndAnswerComment_Insert_obj_for_return;
      }

    @Override
    public String dao_deleteQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentDelete)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(questionAndAnswerCommentDelete);
      }

    @Override
    public String dao_upgradeQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentUpgrade)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(questionAndAnswerCommentUpgrade);
      }
    }
