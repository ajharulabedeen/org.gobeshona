package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.configs.MapSingleton;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import static com.gobeshonabd.configs.SpringApplicationContextInterface.applicationContext;
import com.gobeshonabd.configs.StatusRequestSingleton;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.StatusRequest;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers_QuestionAndAnswer
    {
        @Autowired
        private Services_QuestionAndAnswar_I bean_services_QuestionAndAnswar_I;
    
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
        
        Map map = MapSingleton.getMap();
        
        @RequestMapping(value = "/postQuestion", method = RequestMethod.POST)
        public QuestionAndAnswer_Insert postQuestion( @RequestBody QuestionAndAnswer_Insert questionAndAnswerToPost )
          {     
            return bean_services_QuestionAndAnswar_I.services_postQuestionAndAnswar(questionAndAnswerToPost);
          }
        
        @RequestMapping(value = "/deleteQuestion", method = RequestMethod.DELETE)
        public StatusRequest deleteQuestion( @RequestBody QuestionAndAnswer questionAndAnswerToDelete )
          {
             statusRequest.setOperationStatus(bean_services_QuestionAndAnswar_I.services_deleteQuestionAndAnswar(questionAndAnswerToDelete));
             return statusRequest;
          }
        
        @RequestMapping(value = "/updateQuestion", method = RequestMethod.PUT)
        public StatusRequest updateQuestion( @RequestBody QuestionAndAnswer questionAndAnswerToUpdate )
          {
            statusRequest.setOperationStatus(bean_services_QuestionAndAnswar_I.services_updateQuestionAndAnswar(questionAndAnswerToUpdate));
             return statusRequest;
          }
        
//        Public (No Authentication Needed.)
        @RequestMapping(value = "/getAllQuestionsOnly", method = RequestMethod.GET)
        public List getAllQuestionsOnly(  )
          {
            return bean_services_QuestionAndAnswar_I.services_getAllQuestionsBySubjectOnly();
          }
        
//        Public (No Authentication Needed.) //have to review, here instead of list, have to returm pure JSON.
        @RequestMapping(value = "/getSpecificQuestionsDetails/{specificQuestionID}", method = RequestMethod.GET)
        public QuestionAndAnswer getSpecificQuestionsDetails( @PathVariable int specificQuestionID )
          {
          
              SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
              Session session = sessionFactory.openSession();
//No need. Kept if needed in future
//              Criteria criteria = session.createCriteria(QuestionAndAnswer.class);
//              Criterion search = Restrictions.eq("questionID", specificQuestionID);
//              criteria.add(search);
//
//              List l = criteria.list();
//              QuestionAndAnswer questionAndAnswer = (QuestionAndAnswer) applicationContext.getBean("pojoQuestionAndAnswer");
//              questionAndAnswer = (QuestionAndAnswer) l.get(0);
              
//              criteria = session.createCriteria(QuestionAndAnswer_Insert.class);
//              search = Restrictions.eq("questionID", questionAndAnswer.getQuestionID());
//              criteria.add(search);
//              l = criteria.list();
//              Set set = new HashSet(l);
//              
//              questionAndAnswer.setQuestionComments(set);
//No need. Kept if needed in future

             Object o = session.load(QuestionAndAnswer.class, new Integer(specificQuestionID));
              QuestionAndAnswer qa = (QuestionAndAnswer) o;
              Hibernate.initialize(qa);
              
              session.close();
              sessionFactory.close();
              
              return qa;
          }
    }
