/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerCommentVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;
import com.gobeshonabd.pojos.Users;
import static com.gobeshonabd.voting.Get_Bean_DAO_Generel_Vote_Save_Read_Impl.bean_DAO_Generel_Vote_Save_Read_I;
import java.util.List;

/**
 *
 * @author Dell-3460
 */
public class DAO_Vote_QuestionAndAnswarComment_Impl
        implements 
        DAO_Vote_QuestionAndAnswarComment_I,
        Get_Bean_DAO_Generel_Vote_Save_Read_Impl
    {
        @Override
    public QuestionAndAnswerCommentVotes dao_vote_getQuestionAndAnswarCommentVote(int userID, int QuestionAndAnswarCommentID, int voteValue)
        {
            List uIDcIDvValue = null;
            uIDcIDvValue.add(0, userID);
            uIDcIDvValue.add(1, QuestionAndAnswarCommentID);
            uIDcIDvValue.add(2, voteValue);

            List fieldName_uIDcIDvValue = null;
            fieldName_uIDcIDvValue.add("vote_userID");
            fieldName_uIDcIDvValue.add("vote_QuestionAndAnswerCommentID");
            fieldName_uIDcIDvValue.add("voteValue");

            List listArticlesVotes = bean_DAO_Generel_Vote_Save_Read_I
                    .dao_generel_vote_voteReader(uIDcIDvValue, fieldName_uIDcIDvValue, new QuestionAndAnswerCommentVotes());

            return (QuestionAndAnswerCommentVotes) listArticlesVotes.get(0);
        }

    @Override
    public QuestionAndAnswerComment dao_vote_getQuestionAndAnswerCommentForVote(int QuestionAndAnswarCommentID)
        {
        
            List questionAndAnswerComment = bean_DAO_Generel_Vote_Save_Read_I
                    .dao_generel_vote_contentReader( QuestionAndAnswarCommentID, "questionCommentID", new QuestionAndAnswerComment_Insert());
            return (QuestionAndAnswerComment) questionAndAnswerComment.get(0);
        }

    @Override
    public Users dao_vote_getUserAs_QuestionAndAnswarCommentOwner(int userID)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.dao_vote_getUser_As_ContentOwner(userID);
        }

    @Override
    public String dao_vote_save_QuestionAndAnswarComment_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.custUserVoteData(userVote, userProfileWithVoteData, contentVoteData, voteOperationName);
        }
    }
