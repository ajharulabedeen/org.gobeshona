package com.gobeshonabd.pojos;

import java.util.Set;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;

public class Articles_Insert
    {

//<!--**************** Star Filed Delaration *****************-->
//    1, Auto, Increment
    private int articleID;
//    2, length="500"
    @NotEmpty
    @Length(max = 500)
    private String  articleSubject   = "articleSubject";
//    3
    private int     articleUpvote       = 0;
//    4
    private int     articleDownvote     = 0;
//    5
    private String  articleDate      = "Article post Date";
//    6 length="50000"
    @NotEmpty
    @Length(max = 50000)
    private String  articleContent   = "articleContent";
//    7 length="100"
    @NotEmpty
    @Length(max = 100)
    private String  articleType      = "articleType ";

//************ Extra Column Forign Key ************
//    8 This a  FK
    private int userID_articleByUser;
//<!--**************** End Filed Delaration *****************-->

    
//<!--**************** Start Mapping *****************-->
    //one-to-many with articlesComments Table
    private Set articlesComments;
//<!--**************** End Mapping *****************-->
    
    
    public Articles_Insert()
        {

        }

    public Articles_Insert 
        (
            int articleID,
            String articleSubject,
            int articleUpvote,
            int articleDownvote,
            String articleDate,
            String articleContent,
            String articleType
                            )
        {
        this.articleID = articleID;
        this.articleSubject = articleSubject;
        this.articleUpvote = articleUpvote;
        this.articleDownvote = articleDownvote;
        this.articleDate = articleDate;
        this.articleContent = articleContent;
        this.articleType = articleType;
        }
    
//    1, Auto, Increment ***************************************************************************
    public int getArticleID()
        {
        return articleID;
        }
    public void setArticleID(int articleID)
        {
        this.articleID = articleID;
        }
    
 //    2, ***************************************************************************
    public String getArticleSubject()
        {
        return articleSubject;
        }
    public void setArticleSubject(String articleSubject)
        {
        this.articleSubject = articleSubject;
        }

//    3 ***************************************************************************
    public int getArticleUpvote()
        {
        return articleUpvote;
        }
    public void setArticleUpvote(int articleUpvote)
        {
        this.articleUpvote = articleUpvote;
        }

//    4 ***************************************************************************
    public int getArticleDownvote()
        {
        return articleDownvote;
        }
    public void setArticleDownvote(int articleDownvote)
        {
        this.articleDownvote = articleDownvote;
        }

//    5 ***************************************************************************
    public String getArticleDate()
        {
        return articleDate;
        }
    public void setArticleDate(String articleDate)
        {
        this.articleDate = articleDate;
        }

//    6 ***************************************************************************
    public String getArticleContent()
        {
        return articleContent;
        }

    public void setArticleContent(String articleContent)
        {
        this.articleContent = articleContent;
        }
    
//    7 ***************************************************************************
    public String getArticleType()
        {
        return articleType;
        }
    public void setArticleType(String articleType)
        {
        this.articleType = articleType;
        }
    
//    ******************* This is the extra column *****************************
//    8 ***************************************************************************    
    public int getUserID_articleByUser()
        {
        return userID_articleByUser;
        }

    public void setUserID_articleByUser(int userID_articleByUser)
        {
        this.userID_articleByUser = userID_articleByUser;
        }

    
//    Set ***************************************************************************        
    public Set getArticlesComments()
        {
        return articlesComments;
        }

    public void setArticlesComments(Set articlesComments)
        {
        this.articlesComments = articlesComments;
        }
    }
