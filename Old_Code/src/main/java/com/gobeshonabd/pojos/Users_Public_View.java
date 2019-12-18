package com.gobeshonabd.pojos;

public class Users_Public_View
    {
    
    /**
     *
     * It has no connection with database, Selected column from Database will be
     * read then This class object will be instantiated. so hbm mapping file
     * needed.
     *
     */
    
//      0
        private int userID;
//      1
        private String userFirstName;
//      2  
        private String userLastName;
//      3  
        private String InterestedFields;
//      4  
        private String joinDate;
//      5
        private String skills;
        
//        New Added : 
//    6. 1.Communication Interest
        private int communicationInterest = 0;
//    7. 2.Total articles
        private int totalArticles       = 0;
//    8. 3.Total Question and Answer
        private int totalQuestions      = 0;
////    10. 4.Total answered. 
//        private int totalAnswered       = 0;
////    11. 5.Total posts
//        private int totalPosts          = 0;
//    9. 6.Total up vote
        private float totalUpVote       = 0;
//    10. 7.Total down vote 
        private float totalDownVote     = 0;
////    13. 8.Profile Total Vote (up vote + total vote)
//        private float totalVote = 0;

        
        public Users_Public_View()
        {

        }

    public Users_Public_View(
            int userID,// 0
            String userFirstName,   // 1
            String userLastName,    //2
            String InterestedFields,//3 
            String joinDate,        //4
            String skills,          //5
            
            int communicationInterest,  //6
            int totalArticles,          //7
            int totalQuestions,         //8
//            int totalAnswered,
//            int totalPosts,
            float totalUpVote,      //9
            float totalDownVote     //10
            )
      {
        this.userID = userID;//0
        this.userFirstName      = userFirstName;//1
        this.userLastName       = userLastName;//2
        this.InterestedFields   = InterestedFields;//3
        this.joinDate   = joinDate;//4
        this.skills     = skills;//5
        
        this.communicationInterest  = communicationInterest;//6
        this.totalArticles      = totalArticles;//7
        this.totalQuestions     = totalQuestions;//8
//        this.totalAnswered  = totalAnswered;
//        this.totalPosts     = totalPosts;
        this.totalUpVote    = totalUpVote;//9
        this.totalDownVote  = totalDownVote;//10
      }
    
    
    
//  1 ********************************************************************
    public int getUserID()
      {
        return userID;
      }
    public void setUserID(int userID)
      {
        this.userID = userID;
      }
//  2 ********************************************************************
    public String getUserFirstName()
      {
        return userFirstName;
      }
    public void setUserFirstName(String userFirstName)
      {
        this.userFirstName = userFirstName;
      }
//  3 ********************************************************************
    public String getUserLastName()
      {
        return userLastName;
      }
    public void setUserLastName(String userLastName)
      {
        this.userLastName = userLastName;
      }
//  4 ********************************************************************
    public String getInterestedFields()
      {
        return InterestedFields;
      }
    public void setInterestedFields(String InterestedFields)
      {
        this.InterestedFields = InterestedFields;
      }
//  5 ********************************************************************
    public String getJoinDate()
      {
        return joinDate;
      }
    public void setJoinDate(String joinDate)
      {
        this.joinDate = joinDate;
      }
//  6 ********************************************************************
    public String getSkills()
        {
        return skills;
        }
    public void setSkills(String skills)
        {
        this.skills = skills;
        }
//  7 ********************************************************************
    public int getCommunicationInterest()
        {
            return communicationInterest;
        }
    public void setCommunicationInterest(int communicationInterest)
        {
            this.communicationInterest = communicationInterest;
        }
//  8 ********************************************************************
    public int getTotalArticles()
        {
            return totalArticles;
        }
    public void setTotalArticles(int totalArticles)
        {
            this.totalArticles = totalArticles;
        }
//  9 ********************************************************************
    public int getTotalQuestions()
        {
        return totalQuestions;
        }
    public void setTotalQuestions(int totalQuestions)
        {
        this.totalQuestions = totalQuestions;
        }
//  10 ********************************************************************
//    public int getTotalAnswered()
//        {
//        return totalAnswered;
//        }
//    public void setTotalAnswered(int totalAnswered)
//        {
//        this.totalAnswered = totalAnswered;
//        }
//  11 ********************************************************************
//    public int getTotalPosts()
//        {
//        return totalPosts;
//        }
//    public void setTotalPosts(int totalPosts)
//        {
//        this.totalPosts = totalPosts;
//        }
//  12 ********************************************************************
    public float getTotalUpVote()
        {
        return totalUpVote;
        }

    public void setTotalUpVote(float totalUpVote)
        {
        this.totalUpVote = totalUpVote;
        }
//  13 ********************************************************************
    public float getTotalDownVote()
        {
        return totalDownVote;
        }
    public void setTotalDownVote(float totalDownVote)
        {
        this.totalDownVote = totalDownVote;
        }
//  14 ********************************************************************
//    public float getTotalVote()
//        {
//        return totalVote;
//        }
//    public void setTotalVote(float totalVote)
//        {
//        this.totalVote = totalVote;
//        }
    }
