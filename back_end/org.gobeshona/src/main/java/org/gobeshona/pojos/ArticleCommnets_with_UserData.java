/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.pojos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Dell-3460
 */
public class ArticleCommnets_with_UserData 
    {
//  1
    private String userFirstName = " Please Enter first Name";
//  2 
    private String userLastName = " Please Enter last Name";
//  3
    private String skills = " Skills ";
//  4
    private String joinDate = " Date of Join";
//  5
    private int communicationInterest = 0;
//  6
    private float totalUpVote = 0;
//  7
    private float totalDownVote = 0;

    public ArticleCommnets_with_UserData()
        {
        }

    
//    1 ,Auto
    private int commentId;
//    2  
    private int userID;
//    3
    private String commentDate = "Comment Date";
//    4
    private int commentUpVote = 0;
//    5
    private int commentDownVote = 0;
//    6, length="2000"
    private String commentContent = "Comment Content";

    
    public ArticleCommnets_with_UserData(
            String userFirstName,
            String userLastName,
            String skills,
            String joinDate,
            int     communicationInterest,
            float   totalUpVote,
            float   totalDownVote,
           
            int commentId,
            int userID,
            String commentDate,
            int commentUpVote,
            int commentDownVote,
            String commentContent

    )
        {
            this.userFirstName      = userFirstName ;
            this.userLastName       = userLastName;
            this.skills             = skills;
            this.joinDate           = joinDate ;
            this.communicationInterest = communicationInterest;
            this.totalUpVote        = totalUpVote;
            this.totalDownVote      = totalDownVote;
            
            this.commentId          = commentId;
            this.userID             = userID;
            this.commentDate        = commentDate;
            this.commentUpVote      = commentUpVote;
            this.commentDownVote    = commentDownVote ;
            this.commentContent     = commentContent;
        }
    
    
    
    
    
    
    
//  1  *****************************************************
    public String getUserFirstName()
        {
        return userFirstName;
        }

    public void setUserFirstName(String userFirstName)
        {
        this.userFirstName = userFirstName;
        }
//  2 *****************************************************
    public String getUserLastName()
        {
        return userLastName;
        }

    public void setUserLastName(String userLastName)
        {
        this.userLastName = userLastName;
        }
//  3 *****************************************************
    public String getSkills()
        {
        return skills;
        }

    public void setSkills(String skills)
        {
        this.skills = skills;
        }
//  4  *****************************************************
    public String getJoinDate()
        {
        return joinDate;
        }

    public void setJoinDate(String joinDate)
        {
        this.joinDate = joinDate;
        }
//  5  *****************************************************
    public int getCommunicationInterest()
        {
        return communicationInterest;
        }

    public void setCommunicationInterest(int communicationInterest)
        {
        this.communicationInterest = communicationInterest;
        }
//  6  *****************************************************
    public float getTotalUpVote()
        {
        return totalUpVote;
        }

    public void setTotalUpVote(float totalUpVote)
        {
        this.totalUpVote = totalUpVote;
        }
//  7  *****************************************************
    public float getTotalDownVote()
        {
        return totalDownVote;
        }

    public void setTotalDownVote(float totalDownVote)
        {
        this.totalDownVote = totalDownVote;
        }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//  1  *****************************************************
    public int getCommentId()
        {
        return commentId;
        }

    public void setCommentId(int commentId)
        {
        this.commentId = commentId;
        }
//  2  *****************************************************
    public int getUserID()
        {
        return userID;
        }

    public void setUserID(int userID)
        {
        this.userID = userID;
        }
//  3  *****************************************************
    public String getCommentDate()
        {
        return commentDate;
        }

    public void setCommentDate(String commentDate)
        {
        this.commentDate = commentDate;
        }
//  4  *****************************************************
    public int getCommentUpVote()
        {
        return commentUpVote;
        }

    public void setCommentUpVote(int commentUpVote)
        {
        this.commentUpVote = commentUpVote;
        }
//  5  *****************************************************
    public int getCommentDownVote()
        {
        return commentDownVote;
        }

    public void setCommentDownVote(int commentDownVote)
        {
        this.commentDownVote = commentDownVote;
        }
//  6  *****************************************************
    public String getCommentContent()
        {
        return commentContent;
        }

    public void setCommentContent(String commentContent)
        {
        this.commentContent = commentContent;
        }

    }
