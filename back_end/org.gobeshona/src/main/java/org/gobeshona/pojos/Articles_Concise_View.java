package org.gobeshona.pojos;

public class Articles_Concise_View
    {

/**
 * 
 * It has no connection with database, 
 * Selected column from Database will be read 
 * then 
 *      This class object will be instantiated.
 * so
 *   hbm mapping file needed.
 * 
 */
    
//      1
        private int     articleID;
//      2  
        private String  articleSubject;
//      3 
        private int     articleUpvote;
//      4
        private int     articleDownvote;
//      5
        private String  articleDate;
//      6
        private String  articleType;

//      7 
        private int userID_questionsAskedByUser;
    public Articles_Concise_View()
      {
      
      }

    public Articles_Concise_View(
            int articleID, //0
            String articleSubject, //1
            int articleUpvote,  //2
            int articleDownvote,//3
            String articleDate, //4
            String articleType, //5
            int userID          //6
    )
      {
        this.articleID = articleID;
        this.userID_questionsAskedByUser = userID;
        this.articleSubject = articleSubject;
        this.articleUpvote = articleUpvote;
        this.articleDownvote = articleDownvote;
        this.articleDate = articleDate;
        this.articleType = articleType;
      }

// 1 ******************************************************************************************
    public int getArticleID()
      {
        return articleID;
      }
    public void setArticleID(int articleID)
      {
        this.articleID = articleID;
      }
//  2 ******************************************************************************************
    public int getUserID_questionsAskedByUser()
        {
        return userID_questionsAskedByUser;
        }
    public void setUserID_questionsAskedByUser(int userID_questionsAskedByUser)
        {
        this.userID_questionsAskedByUser = userID_questionsAskedByUser;
        }
//  3 ******************************************************************************************
    public String getArticleSubject()
      {
        return articleSubject;
      }
     public void setArticleSubject(String articleSubject)
      {
        this.articleSubject = articleSubject;
      }
//  4 ******************************************************************************************
    public int getArticleUpvote()
      {
        return articleUpvote;
      }
    public void setArticleUpvote(int articleUpvote)
      {
        this.articleUpvote = articleUpvote;
      }
//  5 ******************************************************************************************
    public int getArticleDownvote()
      {
        return articleDownvote;
      }
    public void setArticleDownvote(int articleDownvote)
      {
        this.articleDownvote = articleDownvote;
      }
//  6 ******************************************************************************************
    public String getArticleDate()
      {
        return articleDate;
      }
    public void setArticleDate(String articleDate)
      {
        this.articleDate = articleDate;
      }
//  7 ******************************************************************************************
    public String getArticleType()
      {
        return articleType;
      }
    public void setArticleType(String articleType)
      {
        this.articleType = articleType;
      }  
    }
