package org.gobeshona.pojos;

import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Users {

    


//***********************Start DB Fields Declarations***************************
//    1, Auto
    private int userID;
//    2, length="200"
//    @Email
    @Length(max = 200)
//    @NotEmpty
    private String emailID;
   // @NotEmpty
//    3, length="500"
   // @Length(min = 6, max = 50)
    private String password;
//    4,  length="500"
    @Length(max = 500)
    private String userFirstName="First Name";
//    5, length="500"
    @Length(max = 500)
    private String userLastName=" Last Name";
//    6
    private String DateOfBarth="Date of Join";
//    7, length="5000"
    @Length(max = 5000)
    private String Address = "Please Enter ur Name";
//    8, length="100"
    @Length(max = 100)
    private String Gender = "Which gender u belongs to";
//    9, length="500"
    @Length(max = 500)
    private String EducationalQualification = "Educational Qualification";
//    10,length="1000"
    @Length(max = 1000)
    private String InterestedFields="Interested Fields";
//    11, length="1000"
    @Length(max = 1000)
    private String CurrentlyWorking = "Currently Working";
//    12,length="200"
    @Length(max = 200)
    private String Occupation = "Occupation";
//    13, length="200"
    @Length(max = 200)
    private String contactInfo = "Contact Info";
//    14
    private String joinDate ="Date of Join";
//    15, length="100"
    @Length(max = 100)
    private String ReligiousView = "Religious View";
//    16, length="100"
    @Length(max = 100)
    private String Nationality = "Nationality";
//     17, length="10000"
    @Length(max = 10000)
    private String expriences = "Expriences";
//     18, length="10000"
    private String skills = " Skills " ;
//  19. This data will not be read by user. 
    private int enable=1;
    
//    >>>>>>>>>>>>>>>>> start New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
//    20. 1.Communication Interest
    private int communicationInterest = 0;
//    21. 2.Total articles
    private int totalArticles    = 0;
//    22. 3.Total Question and Answer
    private int totalQuestions   = 0;
//    23. 4.Total answered. 
    private int totalAnswered    = 0;//may be not needed.
//    24. 5.Total posts
    private int totalPosts       = 0;//may be not needed.
//    25. 6.Total up vote
    private float totalUpVote    = 0;
//    26. 7.Total down vote 
    private float totalDownVote  = 0;
//    27. 8.Profile Total Vote (up vote + total vote)
    private float totalVote      = 0;
//    28. 9.Profile Weight (up vote / total vote)
    private float profileWeight  = 0;
//    >>>>>>>>>>>>>>>>> end New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
    
    
//***********************End DB Fields Declarations*****************************

    
    

    
//***********************Start DB Relations Declarations************************
    //One-to-many with QuestionAndAnswer
    private Set questionsAskedByUser;
    //One-to-many with Article
    private Set articleByUser;
//    //One-to-many with Message //no need, caz it will make complexity in deleting message and message deleting is not needed indeed.
//    private Set messages;
//***********************End DB Relations Declarations**************************

    public Users() 
        {
        
        }
    public Users(String emailID, String pass) 
        {
            this.emailID = emailID;
            this.password = pass;
        }

    /**
     * 
     * This constructor is for to determine vote system.
     * 
     */
    public Users(
            int userID, 
            float totalUpVote, 
            float totalDownVote, 
            float profileWeight ) 
        {
            this.userID = userID; 
            this. totalUpVote   = totalUpVote; 
            this. totalDownVote = totalDownVote; 
            this. profileWeight = profileWeight; 
        }

    
    
    
//    Start Constructior
    public Users(
            int userID,         //1
            String emailID,     //2 
            String password,    //3
            String userFirstName,//4 
            String userLastName, //5
            String dateOfBarth,  //6
            String address, //7
            String gender, //8
            String educationalQualification,//9
            String interestedFields, //10
            String currentlyWorking, //11
            String occupation,  //12
            String contactInfo, //13
            String joinDate,    //14
            String religiousView,   //15
            String nationality,     //16
            String expriences,      //17
            String skills,          //18
            
            Set questionsAskedByUser, //19
            Set articleByUser, //20
//            Set messages //21
            
            //    >>>>>>>>>>>>>>>>> start constructor param. New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
            int communicationInterest,
            int totalArticles,
            int totalQuestions,
            int totalAnswered,
            int totalPosts,
            int totalUpVote,
            int totalDownVote,
            float profileWeight
            //    >>>>>>>>>>>>>>>>> end constructor param New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
    )
        {
            this.userID         = userID; //1
            this.emailID        = emailID; //2
            this.password       = password; //3 
            this.userFirstName  = userFirstName; // 4
            this.userLastName   = userLastName; //5
            this.DateOfBarth    = dateOfBarth; //6
            this.Address        = address; //7
            this.Gender         = gender; //8
            this.EducationalQualification= educationalQualification;//9
            this.InterestedFields   = interestedFields; //10
            this.CurrentlyWorking   = currentlyWorking; //11
            this.Occupation         = occupation; //12
            this.contactInfo        = contactInfo; //13
            this.joinDate           = joinDate; //14
            this.ReligiousView      = religiousView ; //15
            this.Nationality        = nationality; //16
            this.expriences         = expriences; //17
            this.skills = skills;//18
            
            this.questionsAskedByUser   = questionsAskedByUser; //19
            this.articleByUser          = articleByUser; //20
//            this.messages = messages;//21
            
    //    >>>>>>>>>>>>>>>>> start  constructor init New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
            this.communicationInterest  =communicationInterest;
            this.totalArticles  =   totalArticles;
            this.totalQuestions =   totalQuestions;
            this.totalAnswered  =   totalAnswered;
            this.totalPosts     =   totalPosts;
            this.totalUpVote    =   totalUpVote;
            this.totalDownVote  =   totalDownVote;
            this.profileWeight  =   profileWeight;
        //    >>>>>>>>>>>>>>>>> end constructor init New Fields Added 25-5-17 >>>>>>>>>>>>>>>>> 
        }
//    End Constructior
    
    

   
//  1.  *********************** private int userID; ****************************
    public int getUserID()
        {
        return userID;
        }
    public void setUserID(int userID)
        {
        this.userID = userID;
        }
//  2.  *********************** private String emailID; ************************
    public String getEmailID()
        {
        return emailID;
        }
    public void setEmailID(String emailID)
        {
        this.emailID = emailID;
        }
//  3.  ***********************  private String Password; **********************
    public String getPassword()
        {
        return password;
        }

    public void setPassword(String password)
        {
        this.password = password;
        }
//  4.  ***********************  private String userFirstName ******************
    public String getUserFirstName()
        {
        return userFirstName;
        }

    public void setUserFirstName(String userFirstName)
        {
        this.userFirstName = userFirstName;
        }
//  5.  ***********************  private String userLastName="Please Enter last Name"; ***********************
    public String getUserLastName()
        {
        return userLastName;
        }

    public void setUserLastName(String userLastName)
        {
        this.userLastName = userLastName;
        }
//  6.  ***********************  private String DateOfBarth ********************
    public String getDateOfBarth()
        {
        return DateOfBarth;
        }

    public void setDateOfBarth(String DateOfBarth)
        {
        this.DateOfBarth = DateOfBarth;
        }
//  7.  ***********************  private String Address ************************

    public String getAddress()
        {
        return Address;
        }

    public void setAddress(String Address)
        {
        this.Address = Address;
        }
//  8.  ***********************  private String Gender *************************
    public String getGender()
        {
        return Gender;
        }

    public void setGender(String Gender)
        {
        this.Gender = Gender;
        }
//  9.  ***********************  private String Gender *************************
    public String getEducationalQualification()
        {
        return EducationalQualification;
        }

    public void setEducationalQualification(String EducationalQualification)
        {
        this.EducationalQualification = EducationalQualification;
        }
//  10.  ***********************  private String InterestedFields **************
    public String getInterestedFields()
        {
        return InterestedFields;
        }

    public void setInterestedFields(String InterestedFields)
        {
        this.InterestedFields = InterestedFields;
        }
//  11.  ***********************  private String CurrentlyWorking **************
    public String getCurrentlyWorking()
        {
        return CurrentlyWorking;
        }

    public void setCurrentlyWorking(String CurrentlyWorking)
        {
        this.CurrentlyWorking = CurrentlyWorking;
        }
//  12.  ***********************  private String Occupation ********************
    public String getOccupation()
        {
        return Occupation;
        }

    public void setOccupation(String Occupation)
        {
        this.Occupation = Occupation;
        }
//  13.  ***********************  private String contactInfo *******************
    public String getContactInfo()
        {
        return contactInfo;
        }

    public void setContactInfo(String contactInfo)
        {
        this.contactInfo = contactInfo;
        }
//  14.  ***********************  private String joinDate **********************
    public String getJoinDate()
        {
        return joinDate;
        }

    public void setJoinDate(String joinDate)
        {
        this.joinDate = joinDate;
        }
//  15.  ***********************  private String ReligiousView *****************
    public String getReligiousView()
        {
        return ReligiousView;
        }

    public void setReligiousView(String ReligiousView)
        {
        this.ReligiousView = ReligiousView;
        }
//  16.  ***********************  private String Nationality *******************
    public String getNationality()
        {
        return Nationality;
        }

    public void setNationality(String Nationality)
        {
        this.Nationality = Nationality;
        }
//  17.  ***********************  private String expriences ********************
    public String getExpriences()
        {
        return expriences;
        }

    public void setExpriences(String expriences)
        {
        this.expriences = expriences;
        }
//  18.  ***********************  private String skills ************************
    public String getSkills()
        {
        return skills;
        }

    public void setSkills(String skills)
        {
        this.skills = skills;
        }
//  19.  ***********************  private int enable ***************************
    public int getEnable()
        {
        return enable;
        }

    public void setEnable(int enable)
        {
        this.enable = enable;
        }
//  Relations.------------------------------------------------------------------ 

//  1.  ***********************  private Question Asked by users *************************    
    public Set getQuestionsAskedByUser()
        {
        return questionsAskedByUser;
        }
    public void setQuestionsAskedByUser(Set questionsAskedByUser)
        {
        this.questionsAskedByUser = questionsAskedByUser;
        }
//  2.  ***********************  Articles by users *************************    
    public Set getArticleByUser()
        {
        return articleByUser;
        }
    public void setArticleByUser(Set articleByUser)
        {
        this.articleByUser = articleByUser;
        }
//  3.  ***********************  private String Gender *************************    
//no need, caz it will make complexity in deleting message and message deleting is not needed indeed.
//    public Set getMessages()
//        {
//        return messages;
//        }
//
//    public void setMessages(Set messages)
//        {
//        this.messages = messages;
//        }
//  20.  *********************** private int communicationInterest = 0;****************************
    public int getCommunicationInterest()
        {
        return communicationInterest;
        }
    public void setCommunicationInterest(int communicationInterest)
        {
        this.communicationInterest = communicationInterest;
        }
//  21.  ***********************  private int totalArticles    = 0; ****************************
    public int getTotalArticles()
        {
        return totalArticles;
        }
    public void setTotalArticles(int totalArticles)
        {
        this.totalArticles = totalArticles;
        }
//  22.  *********************** private int totalQuestions   = 0; ****************************
    public int getTotalQuestions()
        {
        return totalQuestions;
        }
    public void setTotalQuestions(int totalQuestions)
        {
        this.totalQuestions = totalQuestions;
        }
//  23.  ***********************  private int totalAnswered    = 0; ****************************
    public int getTotalAnswered()
        {
        return totalAnswered;
        }
    public void setTotalAnswered(int totalAnswered)
        {
        this.totalAnswered = totalAnswered;
        }
//  24.  *********************** private int totalPosts       = 0; ****************************
    public int getTotalPosts()
        {
        return totalPosts;
        }
    public void setTotalPosts(int totalPosts)
        {
        this.totalPosts = totalPosts;
        }
//  25.  *********************** private int totalUpVote      = 0; ****************************
    public float getTotalUpVote()
        {
        return totalUpVote;
        }
    public void setTotalUpVote(float totalUpVote)
        {
        this.totalUpVote = totalUpVote;
        }
//  26.  *********************** private int totalDownVote    = 0; ****************************
    public float getTotalDownVote()
        {
        return totalDownVote;
        }
    public void setTotalDownVote(float totalDownVote)
        {
        this.totalDownVote = totalDownVote;
        }
//  27.  *********************** private float total vote= 0;; ****************************
    public float getTotalVote()
        {
        return totalVote;
        }
    public void setTotalVote(float totalVote)
        {
        this.totalVote = totalVote;
        }

//  28.  *********************** private float profileWeight = 0;; ****************************
    public float getProfileWeight()
        {
        return profileWeight;
        }
    public void setProfileWeight(float profileWeight)
        {
        this.profileWeight = profileWeight;
        }    
}
