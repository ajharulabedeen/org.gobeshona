package com.gobeshonabd.pojos;

public class QuestionAndAnswer_View_Summury
    {
        private int     questionID;
        private int     userID;
        private String  questionDate;
        private String  questionType;
        private String  question;
        private int     quesionUpVote;
        private int     quesionDownVote;

    public QuestionAndAnswer_View_Summury()
      {
      }

    public QuestionAndAnswer_View_Summury(
            int     questionID, //0
            int     userID,     //1
            String  questionDate, //2
            String  questionType, //3
            String  question, //4
            int     quesionUpVote,//5 
            int     quesionDownVote //6
            )
      {
        this.questionID = questionID;
        this.userID = userID;
        this.questionDate = questionDate;
        this.questionType = questionType;
        this.question = question;
        this.quesionUpVote = quesionUpVote;
        this.quesionDownVote = quesionDownVote;
      }

    /**
     * @return the questionID
     */
    public int getQuestionID()
      {
        return questionID;
      }

    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(int questionID)
      {
        this.questionID = questionID;
      }

    /**
     * @return the userID
     */
    public int getUserID()
      {
        return userID;
      }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID)
      {
        this.userID = userID;
      }

    /**
     * @return the questionDate
     */
    public String getQuestionDate()
      {
        return questionDate;
      }

    /**
     * @param questionDate the questionDate to set
     */
    public void setQuestionDate(String questionDate)
      {
        this.questionDate = questionDate;
      }

    /**
     * @return the questionType
     */
    public String getQuestionType()
      {
        return questionType;
      }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(String questionType)
      {
        this.questionType = questionType;
      }

    /**
     * @return the question
     */
    public String getQuestion()
      {
        return question;
      }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question)
      {
        this.question = question;
      }

    /**
     * @return the quesionUpVote
     */
    public int getQuesionUpVote()
      {
        return quesionUpVote;
      }

    /**
     * @param quesionUpVote the quesionUpVote to set
     */
    public void setQuesionUpVote(int quesionUpVote)
      {
        this.quesionUpVote = quesionUpVote;
      }

    /**
     * @return the quesionDownVote
     */
    public int getQuesionDownVote()
      {
        return quesionDownVote;
      }

    /**
     * @param quesionDownVote the quesionDownVote to set
     */
    public void setQuesionDownVote(int quesionDownVote)
      {
        this.quesionDownVote = quesionDownVote;
      }
        
        
        
    }
