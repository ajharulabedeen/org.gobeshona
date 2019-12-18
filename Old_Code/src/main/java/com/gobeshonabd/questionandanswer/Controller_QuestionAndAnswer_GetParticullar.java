package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_with_UserData;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.Users;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_QuestionAndAnswer_GetParticullar 
    {

    @RequestMapping(value = "/getQuestionAndAnswerByParticularUser/{userID}", method = RequestMethod.GET)
    public List getQuestionAndAnswerByParticularUser(@PathVariable int userID)
        {

//            To do first violet the Separation of Concern.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(QuestionAndAnswer_Insert.class);
        Criterion search = Restrictions.eq("userID_questionsAskedByUser", userID);
        criteria.add(search);
        criteria.addOrder(Order.desc("questionID"));
        
        List l = criteria.list();
        
        session.close();    
        sessionFactory.close();
        return l;

        }

    @RequestMapping(value = "/getCommentsOfParticularQuestionAndAnswer/{questionAndAnswerID}", method = RequestMethod.GET)
    public List getCommentsOfParticularQuestionAndAnswer(@PathVariable int questionAndAnswerID)
        {

//            To do first violet the Separation of Concern. 
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(QuestionAndAnswerComment_Insert.class);
        Criterion search = Restrictions.eq("questionID", questionAndAnswerID);
        criteria.add(search);
        criteria.addOrder(Order.desc("questionCommentID"));
        
        List l = criteria.list();
        Iterator iterator = l.iterator();
        List questionAndAnswerComment_With_UserData_list = new ArrayList();
        while (iterator.hasNext())
          {
              QuestionAndAnswerComment_Insert qac = (QuestionAndAnswerComment_Insert) iterator.next();
              Users u = getSpecificUserData(qac.getUserID());
              
              questionAndAnswerComment_With_UserData_list.add(
                      new QuestionAndAnswerComment_with_UserData (
                            u.getUserFirstName(),  //String userFirstName
                            u.getUserLastName(),    //String userLastName,
                            u.getSkills(),          //String skills,
                            u.getJoinDate(),//String joinDate,
                            u.getCommunicationInterest(),//,int     communicationInterest,
                            u.getTotalUpVote(),//float   totalUpVote,
                            u.getTotalDownVote(),//float   totalDownVote,
                            
                            qac.getQuestionCommentID(),//int questionCommentID, 
                            qac.getQuestionID(),//int questionID, 
                            qac.getUserID(),//int userID, 
                            qac.getQuestionCommentDate(),//String questionCommentDate, 
                            qac.getQuestionCommentUpVote(),//int questionCommentUpVote, 
                            qac.getQuestionCommentDownVote(),//int questionCommentDownVote, 
                            qac.getQuestionCommentContent(),//String questionCommentContent, 
                            qac.getIsItAnswer()//int isItAnswer
                                    )
              );
          }
        
        System.out.println(""+questionAndAnswerComment_With_UserData_list.size());
        
        session.close();    
        sessionFactory.close();
        return questionAndAnswerComment_With_UserData_list;

        }

    public Users getSpecificUserData(int userID)
        {
          SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
          Session session = sessionFactory.openSession();
          Query qry = session.createQuery(" from Users u where u.userID =" + userID);
          List<Users> l = qry.list();
          Users users = new Users();
          if(l.isEmpty() == false)
            {
              users = l.get(0);
            }
          session.close();    //If session is closed, then unable to return data, lazy loading problem.
          sessionFactory.close();
          return users;
        }
    }
