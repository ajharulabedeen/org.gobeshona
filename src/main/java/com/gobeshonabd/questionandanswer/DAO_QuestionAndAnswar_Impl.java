package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import static com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl.bean_generel_Insert_Update_Delete_SelectAll_I;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Articles_Concise_View;
import com.gobeshonabd.pojos.Articles_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswer_View_Summury;
import com.gobeshonabd.pojos.Users;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO_QuestionAndAnswar_Impl 
        implements DAO_QuestionAndAnswar_I,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_QuestionAndAnswar_Impl()
      {
        
      }

    @Override
//    public String dao_postQuestionAndAnswar(QuestionAndAnswer_Insert questionAndAnswerToInsert)
    public QuestionAndAnswer_Insert dao_postQuestionAndAnswar(QuestionAndAnswer_Insert questionAndAnswerToInsert)
      {
//        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(questionAndAnswerToInsert);
        String dataDeleteStatus = "public String dao_Generel_Delete(Object objectToDelete)";        
        QuestionAndAnswer_Insert questionAndAnswer_Insert_to_return = null;
        
        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            
            Transaction tx = session.beginTransaction();
            session.save(questionAndAnswerToInsert);
            tx.commit();
            
            questionAndAnswer_Insert_to_return = questionAndAnswerToInsert;
          } 
        catch (Exception e)
          {
            System.out.println("\n\n QuestionAndAnswer insert Error : " + e.getClass());
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } 
        finally
          {
            session.close();
            factory.close();
            System.out.println("++++++++++++++++++++++++++++++  QuestionAndAnswer insert Final +++++++++++++++++++++++++++++++++++++++");
          }

        return questionAndAnswer_Insert_to_return;
      }

    @Override
    public String dao_deleteQuestionAndAnswar(QuestionAndAnswer questionAndAnswerToDelete)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(questionAndAnswerToDelete);
      }

    @Override
    public String dao_updateQuestionAndAnswar(QuestionAndAnswer questionAndAnswerToUpdate)
      {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(questionAndAnswerToUpdate);
      }
    
    @Override
    public List<QuestionAndAnswer_View_Summury> dao_getAllQuestionsBySubjectOnly()
      {
        //qaa = QuestionAndAnswer;
        String query = " Select "
                + " qaa.questionID, "//0
                + " qaa.userID_questionsAskedByUser, "//1
                + " qaa.questionDate, "//2
                + " qaa.questionType, "//3
                + " qaa.question, "//4
                + " qaa.quesionUpVote, "//5
                + " qaa.quesionDownVote "//6
                + " from QuestionAndAnswer_Insert qaa " ;
        
        List<QuestionAndAnswer_View_Summury> questionAndAnswer_Concise_Views = new ArrayList<QuestionAndAnswer_View_Summury>();
        List temListQuestionAndAnswer = bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_SelectAll(query);
        Iterator iterator = temListQuestionAndAnswer.iterator();
          while (iterator.hasNext())
            {
              Object[] obj = (Object[]) iterator.next();
              
              int       questionID      =   Integer.parseInt(obj[0].toString());
              int       userID          =   Integer.parseInt(obj[1].toString());
              String    questionDate    =   obj[2].toString();
              String    questionType    =   obj[3].toString();
              String    question        =   obj[4].toString();
              int       quesionUpVote   =   Integer.parseInt(obj[5].toString());
              int       quesionDownVote =   Integer.parseInt(obj[6].toString());
              
              questionAndAnswer_Concise_Views.add(new QuestionAndAnswer_View_Summury(
                      questionID, 
                      userID, 
                      questionDate, 
                      questionType, 
                      question, 
                      quesionUpVote, 
                      quesionDownVote));
            }
        return questionAndAnswer_Concise_Views;        
     }

    @Override
    public List dao_getSpecificQuestionAndAnswerDetails(int questionAndAnswerID)
      {
       
          System.out.println("\n public List<Users> dao_getSpecificUserData(int userID) \n");
          SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
          Session session = sessionFactory.openSession();

          Query qry = session.createQuery(" from QuestionAndAnswer_Insert qaa where qaa.questionID =" + questionAndAnswerID );
          List l = qry.list();
//          session.close();    //If session is closed, then unable to return data, lazy loading problem.
//          sessionFactory.close();
          return l;

            
//        SessionFactory sessionFactory = null;
//        Session session = null;
//        Object o = null;
//        QuestionAndAnswer questionAndAnswerInfo = null;
//        QuestionAndAnswer questionAndAnswerToShow = null;
//
//        try
//          {
//            sessionFactory = HibernateUtil.getSessionFactory();
//            session = sessionFactory.openSession();
//            o = session.load(QuestionAndAnswer.class, new Integer(questionAndAnswerID));
//            
//            questionAndAnswerInfo = (QuestionAndAnswer) o;
//            
//            questionAndAnswerToShow = new QuestionAndAnswer(
//                     questionAndAnswerInfo.getQuestionID() , 
//                     questionAndAnswerInfo.getQuestionDate(), 
//                     questionAndAnswerInfo.getQuesionUpVote(), 
//                     questionAndAnswerInfo.getQuesionDownVote(),
//                     questionAndAnswerInfo.getQuestion(), 
//                     questionAndAnswerInfo.getQuestionDescription(), 
//                     questionAndAnswerInfo.getAnswerID(), 
//                     questionAndAnswerInfo.getQuestionComments()
//            ); 
//          } 
//        catch (Exception e)
//          {
//              System.out.println("\n Error happened in reading specific Question data for details.\n");
//              e.printStackTrace();
//              System.out.println("\n\n");
//          }
//        finally
//          {
//            o = null;
//            questionAndAnswerInfo = null;
//            session.close();
//            sessionFactory.close();
//          }
//        return questionAndAnswerToShow;
      }
        
    }
