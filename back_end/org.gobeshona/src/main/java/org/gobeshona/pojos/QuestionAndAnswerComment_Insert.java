package org.gobeshona.pojos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class QuestionAndAnswerComment_Insert
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
    
    public QuestionAndAnswerComment_Insert()
        {

        }

    public QuestionAndAnswerComment_Insert(
            int questionCommentID, 
            int questionID, 
            int userID, 
            String questionCommentDate, 
            int questionCommentUpVote, 
            int questionCommentDownVote, 
            String questionCommentContent, 
            int isItAnswer  )
        {
        this.questionCommentID = questionCommentID;
        this.userID = userID;
        this.questionCommentDate = questionCommentDate;
        this.questionCommentUpVote = questionCommentUpVote;
        this.questionCommentDownVote = questionCommentDownVote;
        this.questionCommentContent = questionCommentContent;
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

    }
