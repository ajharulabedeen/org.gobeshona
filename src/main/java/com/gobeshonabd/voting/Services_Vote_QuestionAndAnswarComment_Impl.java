package com.gobeshonabd.voting;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerCommentVotes;
import com.gobeshonabd.pojos.QuestionAndAnswerVotes;
import com.gobeshonabd.pojos.Users;

public class Services_Vote_QuestionAndAnswarComment_Impl
        implements 
        Services_Vote_QuestionAndAnswarComment_I
    {
    
//    start Varribale and Bean area  ****************************************************************************
//      Bean Injection  .................................................
        private DAO_Vote_QuestionAndAnswarComment_I bean_DAO_Vote_QuestionAndAnswarComment_I ;
        public DAO_Vote_QuestionAndAnswarComment_I getBean_DAO_Vote_QuestionAndAnswarComment_I()
            {
            return bean_DAO_Vote_QuestionAndAnswarComment_I;
            }
        public void setBean_DAO_Vote_QuestionAndAnswarComment_I(DAO_Vote_QuestionAndAnswarComment_I bean_DAO_Vote_QuestionAndAnswarComment_I)
            {
            this.bean_DAO_Vote_QuestionAndAnswarComment_I = bean_DAO_Vote_QuestionAndAnswarComment_I;
            }
//      Bean Injection  .................................................        
        
        String voteQuestionAndAnswarComment_CustMessage = null;//values will set inside Update and save mehtod.
        
        private QuestionAndAnswerCommentVotes vote_obj_New  = null;//means the new vote, user has given now.
            private int vote_new_QuestionAndAnswerCommentID        = 0 ; 
            private int vote_new_QuestionAndAnswerComment_userID   = 0 ;
            private int vote_new_value  = 0 ;
        
        private QuestionAndAnswerCommentVotes vote_obj_stored = null;
            private int vote_stored_value = 200 ;
        
        private QuestionAndAnswerComment questionAndAnswerComment_obj_voted = null;//the article that has been given vote. taken as insert to get the article owner userID
            private int questionAndAnswerComment_OwnerID    = 0 ;
            private int questionAndAnswerComment_upVote     = 0 ;
            private int questionAndAnswerComment_downVote   = 0 ;
        
        private Users user_obj_as_QuestionAndAnswerCommentOwn   = null ;
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
        public String services_vote_QuestionAndAnswarComment( QuestionAndAnswerCommentVotes questionAndAnswerCommentVotes_New )
            {
                vote_obj_New = questionAndAnswerCommentVotes_New;//means the new vote, user has given now.
                    vote_new_QuestionAndAnswerCommentID         = vote_obj_New.getQuestionAndAnswerComment_voteID();
                    vote_new_QuestionAndAnswerComment_userID    = vote_obj_New.getVote_userID();
                    vote_new_value                      = vote_obj_New.getVoteValue();
        
//                    Date Insertion for vote count.
                vote_obj_New.setVoteDate(GetDate.getDate());    
                    
                    
                vote_obj_stored = getBean_DAO_Vote_QuestionAndAnswarComment_I()
                        .dao_vote_getQuestionAndAnswarCommentVote(vote_new_QuestionAndAnswerComment_userID, vote_new_QuestionAndAnswerCommentID, vote_new_value);
                    
                if( vote_obj_stored != null )
                  {
                    vote_stored_value = vote_obj_stored.getVoteValue();
                  }
                
                questionAndAnswerComment_obj_voted = getBean_DAO_Vote_QuestionAndAnswarComment_I().dao_vote_getQuestionAndAnswerCommentForVote(vote_new_QuestionAndAnswerCommentID);
                    questionAndAnswerComment_OwnerID    = questionAndAnswerComment_obj_voted.getUserID();
                    questionAndAnswerComment_upVote     = questionAndAnswerComment_obj_voted.getQuestionCommentUpVote();
                    questionAndAnswerComment_downVote   = questionAndAnswerComment_obj_voted.getQuestionCommentDownVote();
                    
                user_obj_as_QuestionAndAnswerCommentOwn = getBean_DAO_Vote_QuestionAndAnswarComment_I().dao_vote_getUserAs_QuestionAndAnswarCommentOwner(questionAndAnswerComment_OwnerID);
                    user_totalUpVote    = user_obj_as_QuestionAndAnswerCommentOwn.getTotalUpVote();
                    user_totalDownVote  = user_obj_as_QuestionAndAnswerCommentOwn.getTotalDownVote();
                    user_totalVote      = user_obj_as_QuestionAndAnswerCommentOwn.getTotalVote();
                    user_profileWeight  = user_obj_as_QuestionAndAnswerCommentOwn.getProfileWeight();
                       
//                Stored    &&  new
//                1.                    null   &&                     -1
                if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) )
                  {
                    //set 1 : down
                      System.out.println("if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) )");
                    operations_DownVote();
                    saveQuestionAndAnswerCommentVotes();
                  }
//                2.                    null   &&                      1
                if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) )
                  {
                    //set 2 : Up
                      System.out.println("if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) )");
                    operations_UpVote();
                    saveQuestionAndAnswerCommentVotes();
                  }
//                3.                       0  &&                     -1
                if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) )
                  {
                    //set 1 : Down
                      System.out.println("if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) )");
                    operations_DownVote();
                    vote_obj_stored.setVoteValue(-1);
                    updateQuestionAndAnswerCommentVotes();
                  }
//                4.                       0  &&                      1
                if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) )
                  {
                    //set 2 : Up
                      System.out.println("if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) )");
                    operations_UpVote();
                    vote_obj_stored.setVoteValue(1);
                    updateQuestionAndAnswerCommentVotes();
                  }
//                5.                       1  &&                     -1
                if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )    
                  {
                    //set 1 : down
//                    operations_DownVote();
                    
                      System.out.println("if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )");
                    
                    increase_DownVote_QuestionAndAnswerComment();
                    increase_DownVote_Users();
                    
                    decrease_UpVote_QuestionAndAnswerComment();
                    decrease_UpVote_Users();
                    
                    setProfileWeight_Users();
                    
                    vote_obj_stored.setVoteValue(-1);
                    updateQuestionAndAnswerCommentVotes();
                  }
//                6.                       1  &&                      1
                if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) )
                  {
                    
                      System.out.println("if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) )");
                    
                    decrease_UpVote_QuestionAndAnswerComment();
                    decrease_UpVote_Users();
                    decrease_TotalVote_Users();
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateQuestionAndAnswerCommentVotes();
                  }
//                7.                      -1  &&                      1
                if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )    
                  {
                    // set 2 : Up
                      System.out.println("if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )"); 
//                   operations_UpVote();

                    increase_Upvote_QuestionAndAnswerComment();
                    increase_UpVote_Users();
                    
                    decrease_DownVote_QuestionAndAnswerComment();
                    decrease_UpVote_Users();
                    
                    setProfileWeight_Users();

                    vote_obj_stored.setVoteValue(1);
                    updateQuestionAndAnswerCommentVotes();
                  }
//                8.                      -1  &&                     -1
                if( (vote_stored_value == -1) && ( vote_new_value == -1 ) )    
                  {
                    decrease_DownVote_QuestionAndAnswerComment();
                    decrease_DownVote_Users();
                    decrease_TotalVote_Users();
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateQuestionAndAnswerCommentVotes();
                  }
                return voteQuestionAndAnswarComment_CustMessage;
            }
        private void increase_Upvote_QuestionAndAnswerComment()
            {
                questionAndAnswerComment_upVote = questionAndAnswerComment_upVote + 1;
                questionAndAnswerComment_obj_voted.setQuestionCommentUpVote(questionAndAnswerComment_upVote);
            }

        private void increase_DownVote_QuestionAndAnswerComment()
            {
                questionAndAnswerComment_downVote += 1;
                questionAndAnswerComment_obj_voted.setQuestionCommentDownVote(questionAndAnswerComment_downVote);
            }

        private void increase_UpVote_Users()
            {
                user_totalUpVote += 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalUpVote(user_totalUpVote);
            }

        private void increase_DownVote_Users()
            {
                user_totalDownVote += 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalDownVote(user_totalDownVote);
            }

        private void increase_TotalVote_Users()
            {
                user_totalVote += 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalVote(user_totalDownVote);
            }

        private void decrease_UpVote_QuestionAndAnswerComment()
            {
                questionAndAnswerComment_upVote -= 1;
                questionAndAnswerComment_obj_voted.setQuestionCommentUpVote(questionAndAnswerComment_upVote);
            }

        private void decrease_DownVote_QuestionAndAnswerComment()
            {
                questionAndAnswerComment_downVote -= 1;
                questionAndAnswerComment_obj_voted.setQuestionCommentDownVote(questionAndAnswerComment_downVote);
            }

        private void decrease_UpVote_Users()
            {
                user_totalUpVote -= 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalUpVote(user_totalUpVote);
            }

        private void decrease_DownVote_Users()
            {
                user_totalDownVote -= 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalDownVote(user_totalDownVote);
            }

        private void decrease_TotalVote_Users()
            {
                user_totalVote -= 1;
                user_obj_as_QuestionAndAnswerCommentOwn.setTotalVote(user_totalDownVote);
            }

        private void setProfileWeight_Users()
            {
                user_profileWeight = (float) user_totalUpVote / user_totalVote;
                user_obj_as_QuestionAndAnswerCommentOwn.setProfileWeight(user_profileWeight);
            }

        private void saveQuestionAndAnswerCommentVotes()
            {
                 voteQuestionAndAnswarComment_CustMessage = getBean_DAO_Vote_QuestionAndAnswarComment_I()
                         .dao_vote_save_QuestionAndAnswarComment_vote(vote_obj_New, user_obj_as_QuestionAndAnswerCommentOwn, questionAndAnswerComment_obj_voted, "save");
            }

        private void updateQuestionAndAnswerCommentVotes()
            {
                voteQuestionAndAnswarComment_CustMessage = getBean_DAO_Vote_QuestionAndAnswarComment_I()
                        .dao_vote_save_QuestionAndAnswarComment_vote(vote_obj_stored, user_obj_as_QuestionAndAnswerCommentOwn, questionAndAnswerComment_obj_voted, "update");
            }
        private void operations_DownVote()
            {
                //conditions : 1, 3, 5
                increase_DownVote_QuestionAndAnswerComment();
                increase_DownVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
        private void operations_UpVote()
            {
                //conditions : 2, 4, 7
                increase_Upvote_QuestionAndAnswerComment();
                increase_UpVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
    }
