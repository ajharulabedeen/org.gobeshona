/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerCommentVotes;
import com.gobeshonabd.pojos.Users;

/**
 *
 * @author Dell-3460
 */
public interface DAO_Vote_QuestionAndAnswarComment_I
    {
        public QuestionAndAnswerCommentVotes dao_vote_getQuestionAndAnswarCommentVote(  int userID,   int QuestionAndAnswarCommentID,   int voteValue);
        public QuestionAndAnswerComment dao_vote_getQuestionAndAnswerCommentForVote(  int QuestionAndAnswarCommentID);
        public Users dao_vote_getUserAs_QuestionAndAnswarCommentOwner(  int userID);
        public String dao_vote_save_QuestionAndAnswarComment_vote(  Object userVote,   Object userProfileWithVoteData,   Object contentVoteData,   String voteOperationName);
    }
