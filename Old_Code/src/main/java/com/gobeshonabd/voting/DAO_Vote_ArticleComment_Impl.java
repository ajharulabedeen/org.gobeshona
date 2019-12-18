package com.gobeshonabd.voting;

import com.gobeshonabd.voting.Get_Bean_DAO_Generel_Vote_Save_Read_Impl;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesComments;
import com.gobeshonabd.pojos.ArticlesCommentsVotes;
import com.gobeshonabd.pojos.ArticlesComments_Insert;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.Users;
import java.util.List;

public class DAO_Vote_ArticleComment_Impl 
        implements 
        DAO_Vote_ArticleComment_I,
        Get_Bean_DAO_Generel_Vote_Save_Read_Impl
    {
    
    public DAO_Vote_ArticleComment_Impl()
        {
        
        }

    /**
     * This method will read data from the vote table.
     * 
     * it will go to the Article Vote Table and will read
     * the entire data that userID,articleID,voteValue match with it.
     */
    @Override
    public ArticlesCommentsVotes dao_vote_getArticleCommentVote(int userID, int articleCommentID, int voteValue)
        {
            List uIDcIDvValue = null;
            uIDcIDvValue.add(0, userID);
            uIDcIDvValue.add(1, articleCommentID);
            uIDcIDvValue.add(2, voteValue);

            List fieldName_uIDcIDvValue = null;
            fieldName_uIDcIDvValue.add("vote_userID");
            fieldName_uIDcIDvValue.add("vote_ArticlesCommentsID");
            fieldName_uIDcIDvValue.add("voteValue");

            List listArticlesVotes = bean_DAO_Generel_Vote_Save_Read_I.dao_generel_vote_voteReader(uIDcIDvValue, fieldName_uIDcIDvValue, new ArticlesCommentsVotes());

            return (ArticlesCommentsVotes) listArticlesVotes.get(0);
        }
    /**
     * This method will read data from the Users table; totalVote, upVote, downVote, profileWeight.
     * For this moment it read all data.
     */
    @Override   
    public ArticlesComments_Insert dao_vote_getArticleCommentForVote(int articleCommentID)
        {
            List articlesComments = bean_DAO_Generel_Vote_Save_Read_I
                    .dao_generel_vote_contentReader(articleCommentID, "commentId", new ArticlesComments_Insert());
            return (ArticlesComments_Insert) articlesComments.get(0);
        }

    @Override
    public Users dao_vote_getUserAs_ArticleCommentOwner(int userID)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.dao_vote_getUser_As_ContentOwner(userID);
        }

    /**
     * This method will save if new vote given
     * update if stored vote valued changed.
     * from service all objects will be provided.
     * 
     * @param userVote the vote with content id, userID and vote type.
     * @param userProfileWithVoteData the user who has given the vote.
     * @param contentVoteData the content that have been voted.
     * @param voteOperationName is it a new vote or have to update an existing vote.
     * @return a message will describe does the vote counted or not, does all transection about vote done or not.
     */
    @Override
    public String dao_save_ArticleComment_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.custUserVoteData(userVote, userProfileWithVoteData, contentVoteData, voteOperationName);
        }
    }
