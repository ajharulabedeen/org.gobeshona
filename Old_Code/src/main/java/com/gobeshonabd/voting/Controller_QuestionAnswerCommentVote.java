package com.gobeshonabd.voting;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerCommentVotes;
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
public class Controller_QuestionAnswerCommentVote
    {

    @RequestMapping(value = "saveQuestionAnswerCommentVote", method = RequestMethod.POST)
    public Map saveQuestionAnswerCommentVote(@RequestBody QuestionAndAnswerCommentVotes questionAndAnsweraCommentVotesSave_obj)
        {
        String dataInsertionStatus = "saveQuestionAnswerCommentVote";
        questionAndAnsweraCommentVotesSave_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user object
                Object obj = session.get(Users.class, new Integer(questionAndAnsweraCommentVotesSave_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                //get QuestionAnswerCommentVote object
                obj = session.get(QuestionAndAnswerComment.class, new Integer(questionAndAnsweraCommentVotesSave_obj.getVote_QuestionAndAnswerCommentID() ));
                QuestionAndAnswerComment questionAndAnswerCommentStored_obj = (QuestionAndAnswerComment) obj;
                
                //increase user total vote
                users_obj.setTotalVote( users_obj.getTotalVote() + 1 );
                
                // if negetive vote given.
                if(questionAndAnsweraCommentVotesSave_obj.getVoteValue() == -1)
                    {
                        //increase user down vote and set the new vote value.
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        //increase QuestionAndAnswerComment down vote and set new vote value
                        questionAndAnswerCommentStored_obj.setQuestionCommentDownVote(questionAndAnswerCommentStored_obj.getQuestionCommentDownVote() +1 );
                    }
                // if positive vote given.
                if(questionAndAnsweraCommentVotesSave_obj.getVoteValue() == 1)
                    {
                        //increase user up vote and set
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() + 1);
                        //increase QuestionAndAnswerComment up vote and set
                        questionAndAnswerCommentStored_obj.setQuestionCommentUpVote(questionAndAnswerCommentStored_obj.getQuestionCommentUpVote() + 1 );
                    }
                // change profile weight ratio
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswerCommentStored_obj);
                session.save(questionAndAnsweraCommentVotesSave_obj);
                tx.commit();

                map.put("saveQuestionAndAnswerCommentVote","ok");
            } 
        catch (Exception e)
            {
                map.put("saveQuestionAndAnswerCommentVote","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ saveQuestionAndAnswerCommentVote Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  saveQuestionAndAnswerCommentVote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    
    @RequestMapping(value = "deleteQuestionAnswerCommentVote", method = RequestMethod.DELETE)
    public Map deleteQuestionAnswerCommentVote(@RequestBody QuestionAndAnswerCommentVotes questionAndAnswerCommentVotesDelete_obj)
        {
        String dataInsertionStatus = "deleteQuestionAnswerCommentVote";
        questionAndAnswerCommentVotesDelete_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap(); 
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user objectd
                Object obj = session.get(Users.class, new Integer(questionAndAnswerCommentVotesDelete_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                //get QuestionAndAnswerComment object
                obj = session.get( QuestionAndAnswerComment.class, new Integer(questionAndAnswerCommentVotesDelete_obj.getVote_QuestionAndAnswerCommentID() ));
                QuestionAndAnswerComment questionAndAnswer_obj = (QuestionAndAnswerComment) obj;
                
                //get QuestionAndAnswerCommentVote obj
                obj = session.get( QuestionAndAnswerCommentVotes.class, new Integer(questionAndAnswerCommentVotesDelete_obj.getQuestionAndAnswerComment_voteID() ));
                QuestionAndAnswerCommentVotes questionAndAnswerVotesStored_obj = (QuestionAndAnswerCommentVotes) obj;
                
                //decerese user total vote
                users_obj.setTotalVote( users_obj.getTotalVote() - 1 );
                
                //if vote was negetive
                if(questionAndAnswerCommentVotesDelete_obj.getVoteValue() == -1)
                    {
                        //decrese user total down vote
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        //decrese questonandanswerComment total down vote
                        questionAndAnswer_obj.setQuestionCommentDownVote(questionAndAnswer_obj.getQuestionCommentDownVote() - 1 );
                    }
                //if vote was positive
                if(questionAndAnswerCommentVotesDelete_obj.getVoteValue() == 1)
                    {
                        //decrese user total up vote
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() - 1);
                        //decrese questonandanswerComment total up vote
                        questionAndAnswer_obj.setQuestionCommentUpVote(questionAndAnswer_obj.getQuestionCommentUpVote() - 1 );
                    }
                
                //set user profile weight 
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswer_obj);
                session.delete(questionAndAnswerVotesStored_obj);
                tx.commit();

                map.put("questionAndAnswerCommentVoteDelete","ok");
            } 
        catch (Exception e)
            {
                map.put("questionAndAnswerCommentVoteDelete","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Delete questionAndAnswerComment Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  Final questionAndAnswerComment Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "updateQuestionAnswerCommentVote", method = RequestMethod.PUT)
    public Map updateQuestionAnswerVote(@RequestBody QuestionAndAnswerCommentVotes questionAndAnswerCommentVotesToUpdate_obj)
        {
        String dataInsertionStatus = "updateQuestionAnswerCommentVote";
        
        questionAndAnswerCommentVotesToUpdate_obj.setVoteDate(DateUtil.getDate().toString());
        
        Map map = new HashMap();
        
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                //get user object
                Object obj = session.get(Users.class, new Integer(questionAndAnswerCommentVotesToUpdate_obj.getVote_userID()));
                Users users_obj = (Users) obj;
                
                //get questionAndAnswerComment stored object
                obj = session.get(QuestionAndAnswerComment.class, new Integer(questionAndAnswerCommentVotesToUpdate_obj.getVote_QuestionAndAnswerCommentID() ));
                QuestionAndAnswerComment questionAndAnswerStored_obj = (QuestionAndAnswerComment) obj;
                
                //get questionAndAnswerCommentVote stored object
                obj = session.get(QuestionAndAnswerCommentVotes.class, new Integer(questionAndAnswerCommentVotesToUpdate_obj.getQuestionAndAnswerComment_voteID() ));
                QuestionAndAnswerCommentVotes questionAndAnswerVotesStored_obj = (QuestionAndAnswerCommentVotes) obj;
                
                //if stored was negetive and new is positive
                if( questionAndAnswerVotesStored_obj.getVoteValue() == -1 && questionAndAnswerCommentVotesToUpdate_obj.getVoteValue() == 1)
                    {
                        //change user vote value
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote()+ 1);
                        
                        //change questionAndAnswer vote value
                        questionAndAnswerStored_obj.setQuestionCommentDownVote(questionAndAnswerStored_obj.getQuestionCommentDownVote() - 1 );
                        questionAndAnswerStored_obj.setQuestionCommentUpVote(questionAndAnswerStored_obj.getQuestionCommentUpVote()+ 1 );
                        
                        //change the stored vote value to +1
                        questionAndAnswerVotesStored_obj.setVoteValue(1);
                    }
                //if stored was positive and new is negetive 
                if( questionAndAnswerVotesStored_obj.getVoteValue() == 1 && questionAndAnswerCommentVotesToUpdate_obj.getVoteValue() == -1)
                    {
                        //change user vote value 
                        users_obj.setTotalUpVote( users_obj.getTotalUpVote() - 1);
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        
                        //change questionAndAnswer vote value 
                        questionAndAnswerStored_obj.setQuestionCommentUpVote(questionAndAnswerStored_obj.getQuestionCommentUpVote() - 1 );
                        questionAndAnswerStored_obj.setQuestionCommentDownVote(questionAndAnswerStored_obj.getQuestionCommentDownVote() + 1 );
                        
                        //change the stored vote value to -1
                        questionAndAnswerVotesStored_obj.setVoteValue(-1);
                    }
                
                //chanege profile weight
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(questionAndAnswerStored_obj);
                session.update(questionAndAnswerVotesStored_obj);
                tx.commit();

                map.put("questionAndAnswerCommentVoteUpdate","ok");
            } 
        catch (Exception e)
            {
                map.put("questionAndAnswerCommentVoteUpdate","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ questionAndAnswerComment Vote count Updated ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  questionAndAnswerComment Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    }
