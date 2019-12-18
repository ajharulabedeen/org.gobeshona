
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.ArticlesCommentsVotes;
import com.gobeshonabd.pojos.ArticlesComments_Insert;
import com.gobeshonabd.pojos.Users;

public interface DAO_Vote_ArticleComment_I
    {
         ArticlesCommentsVotes dao_vote_getArticleCommentVote(int userID, int articleCommentID,  int voteValue);
         ArticlesComments_Insert dao_vote_getArticleCommentForVote(int articleCommentID);
         Users dao_vote_getUserAs_ArticleCommentOwner(int userID);
         String dao_save_ArticleComment_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName);
    }
