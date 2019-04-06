package com.gobeshonabd.voting;

import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.pojos.ArticlesCommentsVotes;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerCommentVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Voteing implements SpringApplicationContextInterface
    {

    public Controller_Voteing()
        {
        
        }
    
        @RequestMapping( value = "/articleVote", method = RequestMethod.POST )
        public String articleVote(@RequestBody ArticlesVotes articlesVotes_New )
            {
//                System.out.println("\n\n articleVote : Controller\n\n");
//                System.out.println(" UserID : "+    articlesVotes_New.getVote_userID());
//                System.out.println(" Date   : "+    articlesVotes_New.getVoteDate());
//                System.out.println(" UserID : "+    articlesVotes_New.getVote_articleID());
//                System.out.println(" Vote value : "+articlesVotes_New.getVoteValue());
                
                
                Services_Vote_Article_I bean_services_Vote_Article_I = 
                        (Services_Vote_Article_I) applicationContext.getBean("id_Services_Vote_Article_Impl");
              
                return bean_services_Vote_Article_I.services_vote_Articles(articlesVotes_New);
            }
        @RequestMapping( value = "/articleCommentVote", method = RequestMethod.POST )
        public String articleCommentVote(@RequestBody ArticlesCommentsVotes articlesCommentsVotes_New )
            {
                Services_Vote_ArticleComment_I bean_Vote_ArticleComment_I = 
                        (Services_Vote_ArticleComment_I) applicationContext.getBean("id_Services_Vote_ArticleComment_Impl");
              
                return bean_Vote_ArticleComment_I.services_vote_ArticlesCommentsVotes(articlesCommentsVotes_New);
            }
//        *********************************************************************************************************************
        @RequestMapping( value = "/questionAndanswar", method = RequestMethod.POST )
        public String questionAndanswarVote(@RequestBody QuestionAndAnswerVotes questionAndAnswerVotes_New )
            {
                Services_Vote_QuestionAndAnswar_I bean_Services_Vote_QuestionAndAnswar_I = 
                        (Services_Vote_QuestionAndAnswar_I) applicationContext.getBean("id_Service_Vote_QuestionAndAnswar_Impl");
              
                return bean_Services_Vote_QuestionAndAnswar_I.services_vote_QuestionAndAnswer(questionAndAnswerVotes_New);
            }
        @RequestMapping( value = "/questionAndanswarComment", method = RequestMethod.POST )
        public String questionAndanswarCommentVote(@RequestBody QuestionAndAnswerCommentVotes questionAndAnswerCommentVotes_New )
            {
                Services_Vote_QuestionAndAnswarComment_I bean_Services_Vote_QuestionAndAnswarComment_I = 
                        (Services_Vote_QuestionAndAnswarComment_I) applicationContext.getBean("id_Service_Vote_QuestionAndAnswarComment_Impl");
              
                return bean_Services_Vote_QuestionAndAnswarComment_I.services_vote_QuestionAndAnswarComment(questionAndAnswerCommentVotes_New);
            }
        
    }
