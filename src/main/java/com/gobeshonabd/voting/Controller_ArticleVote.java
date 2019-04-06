package com.gobeshonabd.voting;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.Articles_Insert;
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
public class Controller_ArticleVote
    {

    @RequestMapping(value = "saveArticleVote", method = RequestMethod.POST)
    public Map saveArticleVote(@RequestBody ArticlesVotes articleVotesSave_obj)
        {
        articleVotesSave_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Articles_Insert.class, new Integer(articleVotesSave_obj.getVote_articleID()));
                Articles_Insert articles_obj = (Articles_Insert) obj;
                
                obj = session.get(Users.class, new Integer(articles_obj.getUserID_articleByUser()));
                Users users_obj = (Users) obj;
                
                users_obj.setTotalVote( users_obj.getTotalVote() + 1 );
                
                if(articleVotesSave_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        articles_obj.setArticleDownvote( articles_obj.getArticleDownvote() +1 );
                    }
                if(articleVotesSave_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() + 1);
                        articles_obj.setArticleUpvote(articles_obj.getArticleUpvote() +1 );
                    }
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articles_obj);
                session.save(articleVotesSave_obj);
                tx.commit();

                map.put("articleVoteSave","ok");
            } 
        catch (Exception e)
            {
                map.put("articleVoteSave","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Insert Article  Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  Article Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "deleteArticleVote", method = RequestMethod.DELETE)
    public Map deleteArticleVote(@RequestBody ArticlesVotes articleVotesDelete_obj)
        {
        String dataInsertionStatus = "public Map deleteArticleVote(@RequestBody ArticlesVotes articleVotes)";
        articleVotesDelete_obj.setVoteDate(DateUtil.getDate().toString());
        Map map = new HashMap();
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Users.class, new Integer(articleVotesDelete_obj.getVote_userID()));
                Users users_obj = (Users) obj;
        
                obj = session.get(Articles.class, new Integer(articleVotesDelete_obj.getVote_articleID()));
                Articles articles_obj = (Articles) obj;
                
                obj = session.get(ArticlesVotes.class, new Integer(articleVotesDelete_obj.getArticles_voteID()));
                ArticlesVotes articlesVotesStored_obj = (ArticlesVotes) obj;
                
                users_obj.setTotalVote( users_obj.getTotalVote() - 1 );
                
                if(articleVotesDelete_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        articles_obj.setArticleDownvote( articles_obj.getArticleDownvote() - 1 );
                    }
                if(articleVotesDelete_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote() - 1);
                        articles_obj.setArticleUpvote(articles_obj.getArticleUpvote() - 1 );
                    }
                
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articles_obj);
                session.delete(articlesVotesStored_obj);
                tx.commit();

                map.put("articleVoteDelete","ok");
            } 
        catch (Exception e)
            {
                map.put("articleVoteDelete","fail");
                System.out.println();
                System.out.println("\n\n");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Delete Article  Vote count ++++++++++++++++++++++++++++++++++++++++");
            } 
        finally
            {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  Article Vote count fainal +++++++++++++++++++++++++++++++++++++++");
            }
            return map;
        }
    
    @RequestMapping(value = "updateArticleVote", method = RequestMethod.PUT)
    public Map updateArticleVote(@RequestBody ArticlesVotes articleVotesToUpdate_obj)
        {
        String dataInsertionStatus = "public Map saveArticleVote(@RequestBody ArticlesVotes articleVotes)";
        
        articleVotesToUpdate_obj.setVoteDate(DateUtil.getDate().toString());
        
        Map map = new HashMap();
        
        SessionFactory sessionFactory = null;
        Session session = null;

        try
            {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Object obj = session.get(Users.class, new Integer(articleVotesToUpdate_obj.getVote_userID()));
                Users users_obj = (Users) obj;
                
                obj = session.get(Articles.class, new Integer(articleVotesToUpdate_obj.getVote_articleID()));
                Articles articles_obj = (Articles) obj;
                
                obj = session.get(ArticlesVotes.class, new Integer(articleVotesToUpdate_obj.getArticles_voteID()));
                ArticlesVotes articlesVotesStored_obj = (ArticlesVotes) obj;
                
                if( articlesVotesStored_obj.getVoteValue() == -1 && articleVotesToUpdate_obj.getVoteValue() == 1)
                    {
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() - 1);
                        users_obj.setTotalUpVote(users_obj.getTotalUpVote()+ 1);
                        
                        articles_obj.setArticleDownvote( articles_obj.getArticleDownvote() - 1 );
                        articles_obj.setArticleUpvote(articles_obj.getArticleUpvote() + 1 );
                        
                        articlesVotesStored_obj.setVoteValue(1);
                    }
                if( articlesVotesStored_obj.getVoteValue() == 1 && articleVotesToUpdate_obj.getVoteValue() == -1)
                    {
                        users_obj.setTotalUpVote( users_obj.getTotalUpVote() - 1);
                        users_obj.setTotalDownVote(users_obj.getTotalDownVote() + 1);
                        
                        articles_obj.setArticleUpvote(articles_obj.getArticleUpvote() - 1 );
                        articles_obj.setArticleDownvote(articles_obj.getArticleDownvote() + 1 );
                        
                        articlesVotesStored_obj.setVoteValue(- 1);
                    }
                
                
                users_obj.setProfileWeight( (users_obj.getTotalUpVote()/users_obj.getTotalVote()) );
                
                Transaction tx = session.beginTransaction();
                session.update(users_obj);
                session.update(articles_obj);
                session.update(articlesVotesStored_obj);
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
