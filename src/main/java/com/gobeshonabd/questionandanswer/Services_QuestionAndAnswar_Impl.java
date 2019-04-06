package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.questionandanswer.DAO_QuestionAndAnswar_I;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import java.util.List;

public class Services_QuestionAndAnswar_Impl
        implements Services_QuestionAndAnswar_I, SpringApplicationContextInterface
    {

//Start Bean Area******************************************************************** 
//  ********************************** Injection ********************************** 
    private DAO_QuestionAndAnswar_I dao_questionAndAnswar_I;
    public DAO_QuestionAndAnswar_I getDao_questionAndAnswar_I()
      {
        return dao_questionAndAnswar_I;
      }
    public void setDao_questionAndAnswar_I(DAO_QuestionAndAnswar_I dao_questionAndAnswar_I)
      {
        this.dao_questionAndAnswar_I = dao_questionAndAnswar_I;
      }
//  ********************************** Injection **********************************      
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");

//End Bean Area******************************************************************** 
    
    public Services_QuestionAndAnswar_Impl()
      {
        
      }

    @Override
//    public String services_postQuestionAndAnswar(QuestionAndAnswer_Insert questionAndAnswerToInsert)
    public QuestionAndAnswer_Insert services_postQuestionAndAnswar(QuestionAndAnswer_Insert questionAndAnswerToInsert)
      {
        questionAndAnswerToInsert.setQuestionDate(GetDate.getDate());
        return getDao_questionAndAnswar_I().dao_postQuestionAndAnswar(questionAndAnswerToInsert);
      }

    @Override
    public String services_deleteQuestionAndAnswar(QuestionAndAnswer questionAndAnswerToDelete)
      {
        return getDao_questionAndAnswar_I().dao_deleteQuestionAndAnswar(questionAndAnswerToDelete);
      }

    @Override
    public String services_updateQuestionAndAnswar(QuestionAndAnswer questionAndAnswerToUpdate)
      {
        return getDao_questionAndAnswar_I().dao_updateQuestionAndAnswar(questionAndAnswerToUpdate);
      }

    @Override
    public List services_getAllQuestionsBySubjectOnly()
      {
            return getDao_questionAndAnswar_I().dao_getAllQuestionsBySubjectOnly();
      }

    @Override
    public List services_getSpecificQuestionAndAnswerDetails(int questionAndAnswerID)
      {
        return getDao_questionAndAnswar_I().dao_getSpecificQuestionAndAnswerDetails(questionAndAnswerID);
//************ Start : Not Understood why this segment written here, caz it should be in DAO. Not being understood not deleted.        
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
//                    questionAndAnswerInfo.getQuestionID(), 
//                    questionAndAnswerInfo.getUserID(),
//                    questionAndAnswerInfo.getQuestionDate(),
//                    questionAndAnswerInfo.getQuesionUpVote(), 
//                    questionAndAnswerInfo.getQuesionDownVote(),
//                    questionAndAnswerInfo.getQuestion(),
//                    questionAndAnswerInfo.getQuestionDescription(), 
//                    questionAndAnswerInfo.getAnswerID(), 
//                    questionAndAnswerInfo.getQuestionComments()
//            ); 
//          } 
//        catch (Exception e)
//          {
//              System.out.println("\n Error happened in reading specific Question and Answar data for details.\n");
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
//************ Start : Not Understood why this segment written here, caz it should be in DAO. Not being understood not deleted.        

      }
    
    }
