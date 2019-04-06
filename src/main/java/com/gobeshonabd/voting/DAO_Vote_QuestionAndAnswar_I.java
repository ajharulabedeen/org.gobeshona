/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.Users;

/**
 *
 * @author Dell-3460
 */
public interface DAO_Vote_QuestionAndAnswar_I
    {
        QuestionAndAnswerVotes dao_vote_getQuestionAndAnswarVote(int userID, int QuestionAndAnswarID, int voteValue);
        QuestionAndAnswer_Insert dao_vote_getQuestionAndAnswarForVote(int QuestionAndAnswarID);
        Users dao_vote_getUserAs_QuestionAndAnswarOwner(int userID);
        String dao_save_QuestionAndAnswar_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName);
    }
