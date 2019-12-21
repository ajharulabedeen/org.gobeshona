package org.gobeshona.pojos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class QuestionAndAnswerComment_with_UserData
    {

//    1
    private int questionCommentID;
//    2
    private int userID;
//    3
    private String questionCommentDate = "questionCommentDate";
//    4
    private int questionCommentUpVote = 0;
//    5
    private int questionCommentDownVote = 0;
//    6, length="5000" 
//    @NotEmpty
    @Length(max = 5000)
    private String questionCommentContent = "questionCommentContent";
//    7
    private int isItAnswer = 0;

//    ************ The extra column for FK  ************
//    8
    private int questionID;
    
    
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
    
    
    
    
    
    
    
    
    public QuestionAndAnswerComment_with_UserData()
        {

        }

    public QuestionAndAnswerComment_with_UserData(
            
            String userFirstName,
            String userLastName,
            String skills,
            String joinDate,
            int     communicationInterest,
            float   totalUpVote,
            float   totalDownVote,
            
            int questionCommentID, 
            int questionID, 
            int userID, 
            String questionCommentDate, 
            int questionCommentUpVote, 
            int questionCommentDownVote, 
            String questionCommentContent, 
            int isItAnswer  )
        {
        
        this.userFirstName      = userFirstName ;
        this.userLastName       = userLastName;
        this.skills             = skills;
        this.joinDate           = joinDate ;
        this.communicationInterest = communicationInterest;
        this.totalUpVote        = totalUpVote;
        this.totalDownVote      = totalDownVote;
        
        this.questionCommentID = questionCommentID;
        this.userID = userID;
        this.questionCommentDate        = questionCommentDate;
        this.questionCommentUpVote      = questionCommentUpVote;
        this.questionCommentDownVote    = questionCommentDownVote;
        this.questionCommentContent     = questionCommentContent;
        this.isItAnswer = isItAnswer;
        }

// 1. *************************************************************
    public int getQuestionCommentID()
        {
        return questionCommentID;
        }
    public void setQuestionCommentID(int questionCommentID)
        {
        this.questionCommentID = questionCommentID;
        }
// 2. *************************************************************
    public int getUserID()
        {
        return userID;
        }
    public void setUserID(int userID)
        {
        this.userID = userID;
        }
// 3. *************************************************************
    public String getQuestionCommentDate()
        {
        return questionCommentDate;
        }

    public void setQuestionCommentDate(String questionCommentDate)
        {
        this.questionCommentDate = questionCommentDate;
        }
// 4. *************************************************************
    public int getQuestionCommentUpVote()
        {
        return questionCommentUpVote;
        }

    public void setQuestionCommentUpVote(int questionCommentUpVote)
        {
        this.questionCommentUpVote = questionCommentUpVote;
        }
// 5. *************************************************************
    public int getQuestionCommentDownVote()
        {
        return questionCommentDownVote;
        }

    public void setQuestionCommentDownVote(int questionCommentDownVote)
        {
        this.questionCommentDownVote = questionCommentDownVote;
        }
// 6. *************************************************************
    public String getQuestionCommentContent()
        {
        return questionCommentContent;
        }

    public void setQuestionCommentContent(String questionCommentContent)
        {
        this.questionCommentContent = questionCommentContent;
        }
// 7. *************************************************************
    public int getIsItAnswer()
        {
        return isItAnswer;
        }

    public void setIsItAnswer(int isItAnswer)
        {
        this.isItAnswer = isItAnswer;
        }
    
//    ************************ This is the extra method ************************ 
// 8. *************************************************************
    public int getQuestionID()
        {
        return questionID;
        }

    public void setQuestionID(int questionID)
        {
        this.questionID = questionID;
        }

// 1. *************************************************************    
    public String getUserFirstName()
        {
        return userFirstName;
        }

    public void setUserFirstName(String userFirstName)
        {
        this.userFirstName = userFirstName;
        }
// 2. *************************************************************
    public String getUserLastName()
        {
        return userLastName;
        }

    public void setUserLastName(String userLastName)
        {
        this.userLastName = userLastName;
        }
// 3. *************************************************************
    public String getSkills()
        {
        return skills;
        }

    public void setSkills(String skills)
        {
        this.skills = skills;
        }
// 4. *************************************************************
    public String getJoinDate()
        {
        return joinDate;
        }

    public void setJoinDate(String joinDate)
        {
        this.joinDate = joinDate;
        }
// 5. *************************************************************
    public int getCommunicationInterest()
        {
        return communicationInterest;
        }

    public void setCommunicationInterest(int communicationInterest)
        {
        this.communicationInterest = communicationInterest;
        }
// 6. *************************************************************
    public float getTotalUpVote()
        {
        return totalUpVote;
        }

    public void setTotalUpVote(float totalUpVote)
        {
        this.totalUpVote = totalUpVote;
        }
// 7. *************************************************************
    public float getTotalDownVote()
        {
        return totalDownVote;
        }

    public void setTotalDownVote(float totalDownVote)
        {
        this.totalDownVote = totalDownVote;
        }

    }
