
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.Articles_Insert;
import com.gobeshonabd.pojos.Users;
import java.util.List;



public interface DAO_Vote_Article_I
    {
         ArticlesVotes dao_vote_getStoredArticle_Vote(int userID, int articleID,  int voteValue);
         Articles_Insert dao_vote_getArticleForVote(int articleID);
         Users dao_vote_getUserAs_Article_Owner(int userID);
         String dao_save_article_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName);
    }
