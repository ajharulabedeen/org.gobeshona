package com.gobeshonabd.voting;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import com.gobeshonabd.pojos.Users;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_QuestionAnswerVote
    {

    @RequestMapping(value = "saveQuestionAnswerVote", method = RequestMethod.POST)
    public Map saveQuestionAnswerVote(@RequestBody QuestionAndAnswerVotes questionAndAnsweraVotesSave_obj)
        {
        String dataInsertionStatus = "saveQuestionAnswerVote";
        questionAndAnsweraVotesSave_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user object
                Object obj = session.get(Users.class, new Integer(questionAndAnsweraVotesSave_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                //get QuestionAndAnswer object
                obj = session.get(QuestionAndAnswer.class, new Integer(questionAndAnsweraVotesSave_obj.getQuestionAndAnswer_voteID() ));
                QuestionAndAnswer questionAndAnswerStored_obj = (QuestionAndAnswer) obj;
                
                //increase user total vote
                users_obj.setTotalVote( users_obj.getTotalVote() + 1 );
                
                // if negetive vote given.
                if(questionAndAnsweraVotesSave_obj.getVoteValue() == -1)
                    {
                        //increase user down vote and set
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        //increase QuestionAndAnswer down vote and set
                        questionAndAnswerStored_obj.setQuesionDownVote(questionAndAnswerStored_obj.getQuesionDownVote() +1 );
                    }
                // if positive vote given.
                if(questionAndAnsweraVotesSave_obj.getVoteValue() == 1)
                    {
                        //increase user up vote and set
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() + 1);
                        //increase QuestionAndAnswer up vote and set
                        questionAndAnswerStored_obj.setQuesionUpVote(questionAndAnswerStored_obj.getQuesionUpVote() + 1 );
                    }
                // change profile weight ratio
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswerStored_obj);
                session.save(questionAndAnsweraVotesSave_obj);
                tx.commit();

                map.put("saveQuestionAnswerVote","ok");
            } 
        catch (Exception e)
            {
                map.put("saveQuestionAnswerVote","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ saveQuestionAnswerVote Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  saveQuestionAnswerVote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    
    @RequestMapping(value = "deleteQuestionAnswerVote", method = RequestMethod.DELETE)
    public Map deleteQuestionAnswerVote(@RequestBody QuestionAndAnswerVotes questionAndAnswerVotesDelete_obj)
        {
        String dataInsertionStatus = "deleteQuestionAnswerVote";
        questionAndAnswerVotesDelete_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap(); 
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user objectd
                Object obj = session.get(Users.class, new Integer(questionAndAnswerVotesDelete_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                //get QuestionAndAnswer object
                obj = session.get( QuestionAndAnswer.class, new Integer(questionAndAnswerVotesDelete_obj.getVote_QuestionAndAnswerID() ));
                QuestionAndAnswer questionAndAnswer_obj = (QuestionAndAnswer) obj;
                
                //get QuestionAndAnswerVote obj
                obj = session.get( QuestionAndAnswerVotes.class, new Integer(questionAndAnswerVotesDelete_obj.getQuestionAndAnswer_voteID() ));
                QuestionAndAnswerVotes questionAndAnswerVotesStored_obj = (QuestionAndAnswerVotes) obj;
                
                //decerese user total vote
                users_obj.setTotalVote( users_obj.getTotalVote() - 1 );
                
                //if vote was negetive
                if(questionAndAnswerVotesDelete_obj.getVoteValue() == -1)
                    {
                        //decrese user total down vote
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        //decrese questonandanswer total down vote
                        questionAndAnswer_obj.setQuesionDownVote(questionAndAnswer_obj.getQuesionDownVote() - 1 );
                    }
                //if vote was positive
                if(questionAndAnswerVotesDelete_obj.getVoteValue() == 1)
                    {
                        //decrese user total up vote
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() - 1);
                        //decrese questionAndAnswer total up vote
                        questionAndAnswer_obj.setQuesionUpVote(questionAndAnswer_obj.getQuesionUpVote() - 1 );
                    }
                
                //set user profile weight 
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswer_obj);
                session.delete(questionAndAnswerVotesStored_obj);
                tx.commit();

                map.put("questionAndAnswerVoteDelete","ok");
            } 
        catch (Exception e)
            {
                map.put("questionAndAnswerVoteDelete","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Delete questionAndAnswer Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  Final questionAndAnswer Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "updateQuestionAnswerVote", method = RequestMethod.PUT)
    public Map updateQuestionAnswerVote(@RequestBody QuestionAndAnswerVotes questionAndAnswerVotesToUpdate_obj)
        {
        String dataInsertionStatus = "updateQuestionAnswerVote";
        
        questionAndAnswerVotesToUpdate_obj.setVoteDate(DateUtil.getDate().toString());
        
        Map map = new HashMap();
        
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user object
                Object obj = session.get(Users.class, new Integer(questionAndAnswerVotesToUpdate_obj.getVote_userID()));
                Users users_obj = (Users) obj;
                
                //get questionAndAnswer stored object
                obj = session.get(QuestionAndAnswer.class, new Integer(questionAndAnswerVotesToUpdate_obj.getVote_QuestionAndAnswerID() ));
                QuestionAndAnswer questionAndAnswerStored_obj = (QuestionAndAnswer) obj;
                
                //get questionAndAnswerVote stored object
                obj = session.get(QuestionAndAnswerVotes.class, new Integer(questionAndAnswerVotesToUpdate_obj.getVote_QuestionAndAnswerID() ));
                QuestionAndAnswerVotes questionAndAnswerVotesStored_obj = (QuestionAndAnswerVotes) obj;
                
                //if stored was negetive and new is positive
                if( questionAndAnswerVotesStored_obj.getVoteValue() == -1 && questionAndAnswerVotesToUpdate_obj.getVoteValue() == 1)
                    {
                        //change user vote value
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote()+ 1);
                        
                        //change questionAndAnswer vote value
                        questionAndAnswerStored_obj.setQuesionDownVote(questionAndAnswerStored_obj.getQuesionDownVote() - 1 );
                        questionAndAnswerStored_obj.setQuesionUpVote(questionAndAnswerStored_obj.getQuesionUpVote() + 1 );
                        
                        //change the stored vote value to +1
                        questionAndAnswerVotesStored_obj.setVoteValue(1);
                    }
                //if stored was positive and new is negetive 
                if( questionAndAnswerVotesStored_obj.getVoteValue() == 1 && questionAndAnswerVotesToUpdate_obj.getVoteValue() == -1)
                    {
                        //change user vote value 
                        users_obj.setTotalUpVote( users_obj.getTotalUpVote() - 1);
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        
                        //change questionAndAnswer vote value 
                        questionAndAnswerStored_obj.setQuesionUpVote(questionAndAnswerStored_obj.getQuesionUpVote() - 1 );
                        questionAndAnswerStored_obj.setQuesionDownVote(questionAndAnswerStored_obj.getQuesionDownVote() + 1 );
                        
                        //change the stored vote value to -1
                        questionAndAnswerVotesStored_obj.setVoteValue(- 1);
                    }
                
                //chanege profile weight
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswerStored_obj);
                session.update(questionAndAnswerVotesStored_obj);
                tx.commit();

                map.put("questionAndAnswerVoteUpdate","ok");
            } 
        catch (Exception e)
            {
                map.put("questionAndAnswerVoteUpdate","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ questionAndAnswer Vote count Updated ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  questionAndAnswer Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    }
