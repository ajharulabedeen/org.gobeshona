
package com.gobeshonabd.pojos;

public class ArticlesVotes
    {
        //    1
        private int articles_voteID;
        //    2
        private int vote_userID;
        //    3
        private int vote_articleID;
        //    4
        private String voteDate;
        //    5
        private int voteValue;

    public ArticlesVotes()
        {
            
        }

    public ArticlesVotes(int voteID, int vote_userID, int vote_articleID, String voteDate, int voteValue)
        {
        this.articles_voteID = voteID;
        this.vote_userID = vote_userID;
        this.vote_articleID = vote_articleID;
        this.voteDate = voteDate;
        this.voteValue = voteValue;
        }

//    1 **************************************************
    public int getArticles_voteID()
        {
        return articles_voteID;
        }
    public void setArticles_voteID(int articles_voteID)
        {
        this.articles_voteID = articles_voteID;
        }
//    2 **************************************************
    public int getVote_userID()
        {
        return vote_userID;
        }
    public void setVote_userID(int vote_userID)
        {
        this.vote_userID = vote_userID;
        }
//    3 **************************************************
    public int getVote_articleID()
        {
        return vote_articleID;
        }
    public void setVote_articleID(int vote_articleID)
        {
        this.vote_articleID = vote_articleID;
        }
//    4 **************************************************
    public String getVoteDate()
        {
        return voteDate;
        }
    public void setVoteDate(String voteDate)
        {
        this.voteDate = voteDate;
        }
//    5 **************************************************
    public int getVoteValue()
        {
        return voteValue;
        }
    public void setVoteValue(int voteValue)
        {
        this.voteValue = voteValue;
        }
    }
