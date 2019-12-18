/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.voting;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.pojos.ArticlesCommentsVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.Users;

/**
 *
 * @author Dellprivate 3460
 */
public class Services_Vote_QuestionAndAnswar_Impl
        implements 
        Services_Vote_QuestionAndAnswar_I
    {    
//    start Varribale and Bean area  ****************************************************************************
//      Bean Injection  .................................................
        private DAO_Vote_QuestionAndAnswar_I bean_DAO_Vote_QuestionAndAnswar_I ;
        public DAO_Vote_QuestionAndAnswar_I getBean_DAO_Vote_QuestionAndAnswar_I()
            {
                return bean_DAO_Vote_QuestionAndAnswar_I;
            }
        public void setBean_DAO_Vote_QuestionAndAnswar_I(DAO_Vote_QuestionAndAnswar_I bean_DAO_Vote_QuestionAndAnswar_I)
            {
                this.bean_DAO_Vote_QuestionAndAnswar_I = bean_DAO_Vote_QuestionAndAnswar_I;
            }
//      Bean Injection  .................................................        
        
        String voteQuestionAndAnswar_CustMessage = null;//values will set inside Update and save mehtod.
        
        private QuestionAndAnswerVotes vote_obj_New         = null;//means the new vote, user has given now.
            private int vote_new_QuestionAndAnswerID        = 0 ; 
            private int vote_new_QuestionAndAnswer_userID   = 0 ;
            private int vote_new_value  = 0 ;
        
        private QuestionAndAnswerVotes vote_obj_stored = null;
            private int vote_stored_value = 200 ;
        
        private QuestionAndAnswer_Insert questionAndAnswer_obj_voted = null;//the article that has been given vote. taken as insert to get the article owner userID
            private int questionAndAnswer_OwnerID    = 0 ;
            private int questionAndAnswer_upVote     = 0 ;
            private int questionAndAnswer_downVote   = 0 ;
        
        private Users user_obj_as_ArticlesCommentsOwner   = null ;
            private float user_totalUpVote        = 0 ;
            private float user_totalDownVote      = 0 ;
            private float user_totalVote     = 0 ;
            private float user_profileWeight = 0 ;
//    End Varribale and Bean area  ****************************************************************************
        
            {
              //This block to prevent the execution of Two Conditions.
                System.out.println("\n Stored Values init (Static Block ) : " + vote_stored_value);
            }
            
        @Override    
        public String services_vote_QuestionAndAnswer( QuestionAndAnswerVotes questionAndAnswerVotes_New )
            {
                vote_obj_New = questionAndAnswerVotes_New;//means the new vote, user has given now.
                    vote_new_QuestionAndAnswerID   = vote_obj_New.getVote_QuestionAndAnswerID();
                    vote_new_QuestionAndAnswer_userID   = vote_obj_New.getVote_userID();
                    vote_new_value                      = vote_obj_New.getVoteValue();
        
                    //                    Date Insertion for vote count.
                vote_obj_New.setVoteDate(GetDate.getDate());
                    
                vote_obj_stored = getBean_DAO_Vote_QuestionAndAnswar_I()
                        .dao_vote_getQuestionAndAnswarVote(vote_new_QuestionAndAnswer_userID, vote_new_QuestionAndAnswerID, vote_new_value);
                    
                if( vote_obj_stored != null )
                  {
                    vote_stored_value = vote_obj_stored.getVoteValue();
                  }
                
                
                questionAndAnswer_obj_voted = getBean_DAO_Vote_QuestionAndAnswar_I().dao_vote_getQuestionAndAnswarForVote(vote_new_QuestionAndAnswerID);
                    questionAndAnswer_OwnerID    = questionAndAnswer_obj_voted.getUserID_questionsAskedByUser();
                    questionAndAnswer_upVote     = questionAndAnswer_obj_voted.getQuesionUpVote();
                    questionAndAnswer_downVote   = questionAndAnswer_obj_voted.getQuesionDownVote();
                    
                user_obj_as_ArticlesCommentsOwner = getBean_DAO_Vote_QuestionAndAnswar_I().dao_vote_getUserAs_QuestionAndAnswarOwner(questionAndAnswer_OwnerID);
                    user_totalUpVote    = user_obj_as_ArticlesCommentsOwner.getTotalUpVote();
                    user_totalDownVote  = user_obj_as_ArticlesCommentsOwner.getTotalDownVote();
                    user_totalVote      = user_obj_as_ArticlesCommentsOwner.getTotalVote();
                    user_profileWeight  = user_obj_as_ArticlesCommentsOwner.getProfileWeight();
                       
//                Stored    &&  new
//                1.                    null   &&                     -1
                if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) )
                  {
                    //set 1 : down
                      System.out.println("if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) )");
                    operations_DownVote();
                    saveQuestionAndAnswerVotes();
                  }
//                2.                    null   &&                      1
                if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) )
                  {
                    //set 2 : Up
                      System.out.println("if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) )");
                      
                    operations_UpVote();
                    saveQuestionAndAnswerVotes();
                  }
//                3.                       0  &&                     -1
                if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) )
                  {
                    //set 1 : Down
                      System.out.println("if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) )");
                    operations_DownVote();
                    vote_obj_stored.setVoteValue(-1);
                    updateQuestionAndAnswerVotes();
                  }
//                4.                       0  &&                      1
                if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) )
                  {
                    //set 2 : Up
                    System.out.println("if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) )");
                    operations_UpVote();
                    vote_obj_stored.setVoteValue(1);
                    updateQuestionAndAnswerVotes();
                  }
//                5.                       1  &&                     -1
                if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )    
                  {
                      System.out.println("if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )");
                    
                    //set 1 : down
//                    operations_DownVote();
                    increase_DownVote_QuestionAndAnswer();
                    increase_DownVote_Users();
                    
                    decrease_UpVote_QuestionAndAnswer();
                    decrease_UpVote_Users();
                    
                    setProfileWeight_Users();
                    
                    vote_obj_stored.setVoteValue(-1);
                    updateQuestionAndAnswerVotes();
                  }
//                6.                       1  &&                      1
                if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) )
                  {
                      System.out.println("if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) )");
                    
                    decrease_UpVote_QuestionAndAnswer();
                    decrease_UpVote_Users();
                    decrease_TotalVote_Users();
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateQuestionAndAnswerVotes();
                  }
//                7.                      -1  &&                      1
                if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )    
                  {
                    // set 2 : Up
//                    operations_UpVote();
                    
                      System.out.println("if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )");
                    
                    increase_Upvote_QuestionAndAnswer();
                    increase_UpVote_Users();
                    
                    decrease_DownVote_QuestionAndAnswer();
                    decrease_DownVote_Users();
                    
                    setProfileWeight_Users();
                    
                    vote_obj_stored.setVoteValue(1);
                    updateQuestionAndAnswerVotes();
                  }
//                8.                      -1  &&                     -1
                if( (vote_stored_value == -1) && ( vote_new_value == -1 ) )    
                  {
                      System.out.println("if( (vote_stored_value == -1) && ( vote_new_value == -1 ) )");
                    decrease_DownVote_QuestionAndAnswer();
                    decrease_DownVote_Users();
                    decrease_TotalVote_Users();
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateQuestionAndAnswerVotes();
                  }
                return voteQuestionAndAnswar_CustMessage;
            }
        private void increase_Upvote_QuestionAndAnswer()
            {
                questionAndAnswer_upVote = questionAndAnswer_upVote + 1;
                questionAndAnswer_obj_voted.setQuesionUpVote(questionAndAnswer_upVote);
            }

        private void increase_DownVote_QuestionAndAnswer()
            {
                questionAndAnswer_downVote += 1;
                questionAndAnswer_obj_voted.setQuesionDownVote(questionAndAnswer_downVote);
            }

        private void increase_UpVote_Users()
            {
                user_totalUpVote += 1;
                user_obj_as_ArticlesCommentsOwner.setTotalUpVote(user_totalUpVote);
            }

        private void increase_DownVote_Users()
            {
                user_totalDownVote += 1;
                user_obj_as_ArticlesCommentsOwner.setTotalDownVote(user_totalDownVote);
            }

        private void increase_TotalVote_Users()
            {
                user_totalVote += 1;
                user_obj_as_ArticlesCommentsOwner.setTotalVote(user_totalVote);
            }

        private void decrease_UpVote_QuestionAndAnswer()
            {
                questionAndAnswer_upVote -= 1;
                questionAndAnswer_obj_voted.setQuesionUpVote(questionAndAnswer_upVote);
            }

        private void decrease_DownVote_QuestionAndAnswer()
            {
                questionAndAnswer_downVote -= 1;
                questionAndAnswer_obj_voted.setQuesionDownVote(questionAndAnswer_downVote);
            }

        private void decrease_UpVote_Users()
            {
                user_totalUpVote -= 1;
                user_obj_as_ArticlesCommentsOwner.setTotalUpVote(user_totalUpVote);
            }

        private void decrease_DownVote_Users()
            {
                user_totalDownVote -= 1;
                user_obj_as_ArticlesCommentsOwner.setTotalDownVote(user_totalDownVote);
            }

        private void decrease_TotalVote_Users()
            {
                user_totalVote -= 1;
                user_obj_as_ArticlesCommentsOwner.setTotalVote(user_totalVote);
            }

        private void setProfileWeight_Users()
            {
                user_profileWeight = (float) user_totalUpVote / user_totalVote;
                user_obj_as_ArticlesCommentsOwner.setProfileWeight(user_profileWeight);
            }

        private void saveQuestionAndAnswerVotes()
            {
                 voteQuestionAndAnswar_CustMessage = getBean_DAO_Vote_QuestionAndAnswar_I()
                         .dao_save_QuestionAndAnswar_vote(vote_obj_New, user_obj_as_ArticlesCommentsOwner, questionAndAnswer_obj_voted, "save");
            }

        private void updateQuestionAndAnswerVotes()
            {
                voteQuestionAndAnswar_CustMessage = getBean_DAO_Vote_QuestionAndAnswar_I()
                        .dao_save_QuestionAndAnswar_vote(vote_obj_stored, user_obj_as_ArticlesCommentsOwner, questionAndAnswer_obj_voted, "update");
            }
        private void operations_DownVote()
            {
                //conditions : 1, 3, 
                increase_DownVote_QuestionAndAnswer();
                increase_DownVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
        private void operations_UpVote()
            {
                //conditions : 2, 4, 
                increase_Upvote_QuestionAndAnswer();
                increase_UpVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
    }
