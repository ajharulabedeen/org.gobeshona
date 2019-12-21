package org.gobeshona.articles;

import org.gobeshona.configs.HibernateUtil;
import org.gobeshona.configs.SpringApplicationContextInterface;
import org.gobeshona.pojos.ArticleCommnets_with_UserData;
import org.gobeshona.pojos.Articles;
import org.gobeshona.pojos.ArticlesComments_Insert;
import org.gobeshona.pojos.Articles_Insert;
import org.gobeshona.pojos.Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Article_GetParticullar implements SpringApplicationContextInterface
    {
    
    @RequestMapping(value = "/getArticlesByParticularUser/{userID}", method = RequestMethod.GET)
    public List getArticlesByParticularUser(@PathVariable int userID)
        {

//            To do first violet the Separation of Concern.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Articles_Insert.class);
        Criterion search = Restrictions.eq("userID_articleByUser", userID);
        criteria.add(search);
        criteria.addOrder(Order.desc("articleID"));
        
        List l = criteria.list();
        session.close();    
        sessionFactory.close();
        return l;

        }

    @RequestMapping(value = "/getCommentsOfParticularArticle/{articleID}", method = RequestMethod.GET)
    public List getCommentsOfParticularArticle(@PathVariable int articleID)
        {
             SessionFactory  sessionFactory  = null;
            Session         session         = null;
            
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            
//            Not Working : unable to access the acv object
            String queryString = ""
                    + " SELECT "
                    + "     u.userID,    "
                    + "     u.userFirstName, "
                    + "     u.userLastName,   "
                    + "     ac.commentContent, "
                    + "     ac.articleID_Comment, "
                    + "     ac.commentId, "
                    + "     acv.ArticlesCommentsVotes_voteID,"
                    + "     acv.vote_ArticlesCommentsID,"
                    + "     acv.vote_userID,"
                    + "     acv.voteValue "
                    + ""
                    + " FROM ArticlesComments_Insert ac, Users u, ArticlesCommentsVotes acv"
                    + " WHERE  ac.commentId"
                    + "  not in (select acv from ArticlesCommentsVotes acv "
                    + "         where acv.vote_ArticlesCommentsID = ac.commentId"
                    + "         and acv.vote_userID = 1 )"
                    + " and ac.userID = u.userID and ac.articleID_Comment = 9 order by ac.commentId desc ";
//            Not Working : unable to access the acv object                    

            Query qry = session.createQuery(queryString );
            List list = qry.list();
            List message_read_list = new ArrayList();
//          
            String nativeSQl = " SELECT "
                    + "             users.user_id, "//0
                    + "             users.user_first_name, "//1
                    + "             users.user_last_name, "//2
                    + "             users.join_date, "//3
                    + "             users.total_up_vote, "//4
                    + "             users.total_down_vote, "//5
                    + "             articles_comments.comment_content,"//6
                    + "             articles_comments.article_id_comment, "//7
                    + "             articles_comments.comment_id, "//8
                    + "             articles_comments_votes.vote_articles_comments_id, "//9
                    + "             articles_comments_votes.vote_user_id, "//10
                    + "             articles_comments_votes.vote_value, "//11
                    + "             articles_comments.comment_date "//12
                    + "         FROM "
                    + "             users "
                    + "         INNER JOIN "
                    + "             articles_comments "
                    + "             ON articles_comments.user_id = users.user_id "
                    + "             AND articles_comments.article_id_comment = 9 "
                    + "         LEFT JOIN articles_comments_votes "
                    + "             ON articles_comments.comment_id = articles_comments_votes.vote_articles_comments_id "
                    + "             AND articles_comments_votes.vote_user_id = 1 "
                    + "         ORDER BY articles_comments.comment_id DESC ";
            
            List nativeList = session.createSQLQuery(nativeSQl).list();
            
//                Iterator iterator = list.iterator();
                Iterator iterator = nativeList.iterator();
                while (iterator.hasNext())
                  {
                    Object[] next = (Object[]) iterator.next();
                    Map map = new HashMap();
                    map.put("userID", next[0]);
                    map.put("userFirstName", next[1]);
                    map.put("userLastName", next[2]);
                    map.put("joinDate", next[3]);
                    map.put("totalUpVote", next[4]);
                    map.put("totalDownVote", next[5]);
                    
                    map.put("commentContent", next[6]);
                    map.put("articleID_Comment", next[7]);
                    map.put("commentId", next[8]);
                    
                    map.put("vote_articles_comments_id", next[9]);
                    map.put("vote_user_id", next[10]);
                    map.put("vote_value", next[11]);
                    map.put("commentDate", next[12]);
                    message_read_list.add(map);
                  }//while (iterator.hasNext())

            session.close();
            sessionFactory.close();

            return message_read_list;
        }//    public List getCommentsOfParticularArticle(@PathVariable int articleID)

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
