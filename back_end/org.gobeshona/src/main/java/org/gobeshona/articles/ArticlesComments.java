package org.gobeshona.articles;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ArticlesComments
    {

//    ********************* Start of Varriable Declaration *******************
//    1 ,Auto
    private int commentId;
//    2  FK, Table name Users
//    @NotEmpty
    private int userID;
//    3
    private String commentDate="coment Date";
//    4
    private int commentUpVote = 0;
//    5
    private int commentDownVote = 0;
//    6, length="2000"
    @NotEmpty
    @Length(max = 2000)
    private String commentContent = "Artcile Comment content";
//********************* End of Varriable Declaration *******************

    public ArticlesComments()
        {
        
        }

    public ArticlesComments(
            int commentId, 
            int userID, 
            String commentDate, 
            int commentUpVote, 
            int commentDownVote, 
            String commentContent   )
        {
        this.commentId = commentId;
        this.userID = userID;
        this.commentDate = commentDate;
        this.commentUpVote = commentUpVote;
        this.commentDownVote = commentDownVote;
        this.commentContent = commentContent;
        }
    
// 1  ***************************************************************   
    public int getCommentId()
        {
        return commentId;
        }

    public void setCommentId(int commentId)
        {
        this.commentId = commentId;
        }
// 2  ***************************************************************  
    public int getUserID()
        {
        return userID;
        }

    public void setUserID(int userID)
        {
        this.userID = userID;
        }
    
// 3  ***************************************************************      
    public String getCommentDate()
        {
        return commentDate;
        }

    public void setCommentDate(String commentDate)
        {
        this.commentDate = commentDate;
        }
// 4  ***************************************************************  
    public int getCommentUpVote()
        {
        return commentUpVote;
        }

    public void setCommentUpVote(int commentUpVote)
        {
        this.commentUpVote = commentUpVote;
        }

// 5  ***************************************************************  
    public int getCommentDownVote()
        {
        return commentDownVote;
        }

    public void setCommentDownVote(int commentDownVote)
        {
        this.commentDownVote = commentDownVote;
        }

// 6  ***************************************************************  
    public String getCommentContent()
        {
        return commentContent;
        }

    public void setCommentContent(String CommentContent)
        {
        this.commentContent = CommentContent;
        }



    }
