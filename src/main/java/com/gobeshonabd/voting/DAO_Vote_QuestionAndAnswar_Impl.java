/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.Users;
import static com.gobeshonabd.voting.Get_Bean_DAO_Generel_Vote_Save_Read_Impl.bean_DAO_Generel_Vote_Save_Read_I;
import java.util.List;

/**
 *
 * @author Dell-3460
 */
public class DAO_Vote_QuestionAndAnswar_Impl
        implements 
        DAO_Vote_QuestionAndAnswar_I,
        Get_Bean_DAO_Generel_Vote_Save_Read_Impl
    {

    public DAO_Vote_QuestionAndAnswar_Impl()
        {
        }

    @Override
    public QuestionAndAnswerVotes dao_vote_getQuestionAndAnswarVote(int userID, int QuestionAndAnswarID, int voteValue)
        {
            List uIDcIDvValue = null;
            uIDcIDvValue.add(0, userID);
            uIDcIDvValue.add(1, QuestionAndAnswarID);
            uIDcIDvValue.add(2, voteValue);

            List fieldName_uIDcIDvValue = null;
            fieldName_uIDcIDvValue.add("vote_userID");
            fieldName_uIDcIDvValue.add("vote_QuestionAndAnswerID");
            fieldName_uIDcIDvValue.add("voteValue");

            List listArticlesVotes = bean_DAO_Generel_Vote_Save_Read_I.dao_generel_vote_voteReader(uIDcIDvValue, fieldName_uIDcIDvValue, new QuestionAndAnswerVotes());

            return (QuestionAndAnswerVotes) listArticlesVotes.get(0);
        }

    @Override
    public String dao_save_QuestionAndAnswar_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.custUserVoteData(userVote, userProfileWithVoteData, contentVoteData, voteOperationName);
        }

    @Override
    public QuestionAndAnswer_Insert dao_vote_getQuestionAndAnswarForVote(int QuestionAndAnswarID)
        {
            List questionAndAnswer  = bean_DAO_Generel_Vote_Save_Read_I
                    .dao_generel_vote_contentReader(QuestionAndAnswarID, "questionID", new QuestionAndAnswer_Insert());
            return (QuestionAndAnswer_Insert) questionAndAnswer.get(0);
        }

    @Override
    public Users dao_vote_getUserAs_QuestionAndAnswarOwner(int userID)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.dao_vote_getUser_As_ContentOwner(userID);
        }    
    }
