package com.gobeshonabd.pojos;

import java.util.Set;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class QuestionAndAnswer
    {

//*********************** Start DB Fields Declarations***********************************
//    1 Auto.
    private int questionID;
//    2
    private String questionDate = "questionDate ";
//    3
    private int quesionUpVote = 0;
//    4
    private int quesionDownVote = 0;
//    5 , length="500"
    @NotEmpty
    @Length(max = 500)
    private String question = "question";
//    6 , length="5000"
    @NotEmpty
    @Length(max = 5000)
    private String questionDescription;
//    7
    private int answerID;
//    8
    private String questionType;
//***********************End DB Fields Declarations***********************************

    
//*********************** Start DB Relations Declarations***********************************
    //one-to-many with QuestionAndAnswerComment
    private Set questionComments;
//*********************** End DB Relations Declarations*************************************

    public QuestionAndAnswer()
        {
        }

    public QuestionAndAnswer(
            int questionID, 
            String questionDate, 
            int quesionUpVote, 
            int quesionDownVote, 
            String question, 
            String questionDescription, 
            int answerID, 
            Set questionComments )
        {
        this.questionID = questionID;
        this.questionDate = questionDate;
        this.quesionUpVote = quesionUpVote;
        this.quesionDownVote = quesionDownVote;
        this.question = question;
        this.questionDescription = questionDescription;
        this.answerID = answerID;
        this.questionComments = questionComments;
        }

//  1 ****************************************************** 
    public int getQuestionID()
        {
        return questionID;
        }
    public void setQuestionID(int questionID)
        {
        this.questionID = questionID;
        }
//  2 ******************************************************
    public String getQuestionDate()
        {
        return questionDate;
        }
    public void setQuestionDate(String questionDate)
        {
        this.questionDate = questionDate;
        }
//  3 ******************************************************
    public int getQuesionUpVote()
        {
        return quesionUpVote;
        }
    public void setQuesionUpVote(int quesionUpVote)
        {
        this.quesionUpVote = quesionUpVote;
        }
//  4 ******************************************************
    public int getQuesionDownVote()
        {
        return quesionDownVote;
        }
    public void setQuesionDownVote(int quesionDownVote)
        {
        this.quesionDownVote = quesionDownVote;
        }
//  5 ******************************************************
    public String getQuestion()
        {
        return question;
        }
    public void setQuestion(String question)
        {
        this.question = question;
        }
//  6 ******************************************************
    public String getQuestionDescription()
        {
        return questionDescription;
        }
    public void setQuestionDescription(String questionDescription)
        {
        this.questionDescription = questionDescription;
        }
//  7 ******************************************************
    public int getAnswerID()
        {
        return answerID;
        }
    public void setAnswerID(int answerID)
        {
        this.answerID = answerID;
        }
//  8 ******************************************************
    public String getQuestionType()
        {
        return questionType;
        }
    public void setQuestionType(String questionType)
        {
        this.questionType = questionType;
        }

//   ******************************************************
    public Set getQuestionComments()
        {
        return questionComments;
        }
    public void setQuestionComments(Set questionComments)
        {
        this.questionComments = questionComments;
        }
    
    }
