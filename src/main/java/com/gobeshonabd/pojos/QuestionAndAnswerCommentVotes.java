
package com.gobeshonabd.pojos;

public class QuestionAndAnswerCommentVotes
    {
        //    1
        private int questionAndAnswerComment_voteID;
        //    2
        private int vote_userID;
        //    3
        private int vote_QuestionAndAnswerCommentID;
        //    4
        private String voteDate;
        //    5
        private int voteValue;

    public QuestionAndAnswerCommentVotes()
        {
        }

    public QuestionAndAnswerCommentVotes(
            int questionAndAnswerComment_voteID,
            int vote_userID, 
            int vote_QuestionAndAnswerCommentID, 
            String voteDate, 
            int voteValue)
        {
        this.questionAndAnswerComment_voteID = questionAndAnswerComment_voteID;
        this.vote_userID = vote_userID;
        this.vote_QuestionAndAnswerCommentID = vote_QuestionAndAnswerCommentID;
        this.voteDate = voteDate;
        this.voteValue = voteValue;
        }
//  1   ************************************************************************
    public int getQuestionAndAnswerComment_voteID()
        {
        return questionAndAnswerComment_voteID;
        }
    public void setQuestionAndAnswerComment_voteID(int questionAndAnswerComment_voteID)
        {
        this.questionAndAnswerComment_voteID = questionAndAnswerComment_voteID;
        }
//  2   ************************************************************************
    public int getVote_userID()
        {
        return vote_userID;
        }
    public void setVote_userID(int vote_userID)
        {
        this.vote_userID = vote_userID;
        }
//  3   ************************************************************************
    public int getVote_QuestionAndAnswerCommentID()
        {
        return vote_QuestionAndAnswerCommentID;
        }
    public void setVote_QuestionAndAnswerCommentID(int vote_QuestionAndAnswerCommentID)
        {
        this.vote_QuestionAndAnswerCommentID = vote_QuestionAndAnswerCommentID;
        }
//  4   ************************************************************************
    public String getVoteDate()
        {
        return voteDate;
        }
    public void setVoteDate(String voteDate)
        {
        this.voteDate = voteDate;
        }
//  5   ************************************************************************
    public int getVoteValue()
        {
        return voteValue;
        }

    public void setVoteValue(int voteValue)
        {
        this.voteValue = voteValue;
        }
    
    }
