
package org.gobeshona.pojos;

public class ArticlesCommentsVotes
    {    
        //    1
        private int ArticlesCommentsVotes_voteID;
        //    2
        private int vote_userID;
        //    3
        private int vote_ArticlesCommentsID;
        //    4
        private String voteDate;
        //    5
        private int voteValue;

    public ArticlesCommentsVotes()
        {
        }

    public ArticlesCommentsVotes(int voteID, int vote_userID, int vote_ArticlesCommentsID, String voteDate, int voteValue)
        {
        this.ArticlesCommentsVotes_voteID = voteID;
        this.vote_userID = vote_userID;
        this.vote_ArticlesCommentsID = vote_ArticlesCommentsID;
        this.voteDate = voteDate;
        this.voteValue = voteValue;
        }
//  1   ********************************************************************
    public int getArticlesCommentsVotes_voteID()
        {
        return ArticlesCommentsVotes_voteID;
        }

    public void setArticlesCommentsVotes_voteID(int ArticlesCommentsVotes_voteID)
        {
        this.ArticlesCommentsVotes_voteID = ArticlesCommentsVotes_voteID;
        }
//  2   ********************************************************************
    public int getVote_userID()
        {
        return vote_userID;
        }
    public void setVote_userID(int vote_userID)
        {
        this.vote_userID = vote_userID;
        }
//  3   ********************************************************************
    public int getVote_ArticlesCommentsID()
        {
        return vote_ArticlesCommentsID;
        }
    public void setVote_ArticlesCommentsID(int vote_ArticlesCommentsID)
        {
        this.vote_ArticlesCommentsID = vote_ArticlesCommentsID;
        }
//  4   ********************************************************************
    public String getVoteDate()
        {
        return voteDate;
        }
    public void setVoteDate(String voteDate)
        {
        this.voteDate = voteDate;
        }
//  5   ********************************************************************
    public int getVoteValue()
        {
        return voteValue;
        }
    public void setVoteValue(int voteValue)
        {
        this.voteValue = voteValue;
        }    
    }
