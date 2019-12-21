
package org.gobeshona.pojos;

public class QuestionAndAnswerVotes
    {
        //    1
        private int questionAndAnswer_voteID;
        //    2
        private int vote_userID;
        //    3
        private int vote_QuestionAndAnswerID;
        //    4
        private String voteDate;
        //    5
        private int voteValue;

    public QuestionAndAnswerVotes()
        {
        }

    public QuestionAndAnswerVotes(
            int questionAndAnswer_voteID, 
            int vote_userID, 
            int vote_QuestionAndAnswerID, 
            String voteDate, 
            int voteValue)
        {
        this.questionAndAnswer_voteID = questionAndAnswer_voteID;
        this.vote_userID = vote_userID;
        this.vote_QuestionAndAnswerID = vote_QuestionAndAnswerID;
        this.voteDate = voteDate;
        this.voteValue = voteValue;
        }
//  1   ************************************************************************
    public int getQuestionAndAnswer_voteID()
        {
        return questionAndAnswer_voteID;
        }
    public void setQuestionAndAnswer_voteID(int questionAndAnswer_voteID)
        {
        this.questionAndAnswer_voteID = questionAndAnswer_voteID;
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
    public int getVote_QuestionAndAnswerID()
        {
        return vote_QuestionAndAnswerID;
        }
    public void setVote_QuestionAndAnswerID(int vote_QuestionAndAnswerID)
        {
        this.vote_QuestionAndAnswerID = vote_QuestionAndAnswerID;
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
