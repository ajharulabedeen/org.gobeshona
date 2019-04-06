package com.gobeshonabd.voting;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesComments;
import com.gobeshonabd.pojos.ArticlesCommentsVotes;
import com.gobeshonabd.pojos.ArticlesVotes;
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
public class Controller_ArticleCommentVote
    {

    @RequestMapping(value = "saveArticleCommentVote", method = RequestMethod.POST)
    public Map saveArticleCommentVote(@RequestBody ArticlesCommentsVotes articleCommentsVotesSave_obj )
        {
        articleCommentsVotesSave_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Users.class, new Integer(articleCommentsVotesSave_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                obj = session.get(ArticlesComments.class, new Integer(articleCommentsVotesSave_obj.getVote_ArticlesCommentsID()));
                ArticlesComments articlesCommentStored_obj = (ArticlesComments) obj;
                
                users_obj.setTotalVote( users_obj.getTotalVote() + 1 );
                if(articleCommentsVotesSave_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        articlesCommentStored_obj.setCommentDownVote(articlesCommentStored_obj.getCommentDownVote() +1 );
                    }
                if(articleCommentsVotesSave_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() + 1);
                        articlesCommentStored_obj.setCommentUpVote(articlesCommentStored_obj.getCommentUpVote() +1 );
                    }
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articlesCommentStored_obj);
                session.save(articleCommentsVotesSave_obj);
                tx.commit();

                map.put("articleCommentVoteSave","ok");
            } 
        catch (Exception e)
            {
                map.put("articleCommentVoteSave","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ articleCommentVote Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  articleCommentVote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "deleteArticleCommentVote", method = RequestMethod.DELETE)
    public Map deleteArticleCommentVote(@RequestBody ArticlesCommentsVotes articleCommentsVotesDelete_obj )
        {
        String dataInsertionStatus = "deleteArticleCommentVote";
        
        articleCommentsVotesDelete_obj.setVoteDate(DateUtil.getDate().toString() );
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;
        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Users.class, new Integer(articleCommentsVotesDelete_obj.getVote_userID() ));
                Users users_obj = (Users) obj;
        
                obj = session.get(ArticlesComments.class, new Integer(articleCommentsVotesDelete_obj.getVote_ArticlesCommentsID() ));
                ArticlesComments articlesComments_obj = (ArticlesComments) obj;
                
                obj = session.get(ArticlesCommentsVotes.class, new Integer(articleCommentsVotesDelete_obj.getArticlesCommentsVotes_voteID() ));
                ArticlesCommentsVotes articlesVotesStored_obj = (ArticlesCommentsVotes) obj;
                
                users_obj.setTotalVote( users_obj.getTotalVote() - 1 );       
                if( articleCommentsVotesDelete_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        articlesComments_obj.setCommentDownVote( articlesComments_obj.getCommentDownVote() - 1 );
                    }
                if( articleCommentsVotesDelete_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() - 1);
                        articlesComments_obj.setCommentUpVote(articlesComments_obj.getCommentUpVote() - 1 );
                    }       
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articlesComments_obj);
                session.delete(articlesVotesStored_obj);
                tx.commit();

                map.put("deleteArticleCommentVote","ok");
            } 
        catch (Exception e)
            {
                map.put("deleteArticleCommentVote","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ deleteArticleComment Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  deleteArticleComment Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "updateArticleCommentVote", method = RequestMethod.PUT)
    public Map updateArticleCommentVote(@RequestBody ArticlesCommentsVotes articleCommentsVotesToUpdate_obj)
        {
        String dataInsertionStatus = "updateArticleCommentVote";
        
        articleCommentsVotesToUpdate_obj.setVoteDate(DateUtil.getDate().toString());
        
        Map map = new HashMap();
        
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Users.class, new Integer(articleCommentsVotesToUpdate_obj.getVote_userID() ));
                Users users_obj = (Users) obj;
        
                obj = session.get(ArticlesComments.class, new Integer(articleCommentsVotesToUpdate_obj.getVote_ArticlesCommentsID() ));
                ArticlesComments articlesCommentsStored_obj = (ArticlesComments) obj;
                
                obj = session.get(ArticlesCommentsVotes.class, new Integer(articleCommentsVotesToUpdate_obj.getArticlesCommentsVotes_voteID() ));
                ArticlesCommentsVotes articlesCommentVotesStored_obj = (ArticlesCommentsVotes) obj;
         
                
                if( articlesCommentVotesStored_obj.getVoteValue() == -1 && articleCommentsVotesToUpdate_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote()+ 1);
                        
                        articlesCommentsStored_obj.setCommentDownVote(articlesCommentsStored_obj.getCommentDownVote() - 1 );
                        articlesCommentsStored_obj.setCommentUpVote(articlesCommentsStored_obj.getCommentUpVote() + 1 );
                        
                        articlesCommentVotesStored_obj.setVoteValue(1);
                    }
                if( articlesCommentVotesStored_obj.getVoteValue() == 1 && articleCommentsVotesToUpdate_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalUpVote( users_obj.getTotalUpVote() - 1);
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        
                        articlesCommentsStored_obj.setCommentUpVote(articlesCommentsStored_obj.getCommentUpVote() - 1 );
                        articlesCommentsStored_obj.setCommentDownVote(articlesCommentsStored_obj.getCommentDownVote() + 1 );
                        
                        articlesCommentVotesStored_obj.setVoteValue(-1);
                    }
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articlesCommentsStored_obj);
                session.update(articlesCommentVotesStored_obj);
                tx.commit();

                map.put("articleVoteUpdate","ok");
            } 
        catch (Exception e)
            {
                map.put("articleVoteUpdate","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Insert Article  Vote count Updated ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  Article Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    }
