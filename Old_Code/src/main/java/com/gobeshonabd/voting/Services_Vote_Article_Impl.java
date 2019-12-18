
package com.gobeshonabd.voting;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.Articles_Insert;
import com.gobeshonabd.pojos.Users;


public class Services_Vote_Article_Impl
        implements 
        Services_Vote_Article_I
    {
    
//    start Varribale and Bean area  ****************************************************************************
//      Bean Injection  .................................................
        private DAO_Vote_Article_I bean_DAO_Vote_Article_I ;
        public DAO_Vote_Article_I getBean_DAO_Vote_Article_I()
            {
                return bean_DAO_Vote_Article_I;
            }
        public void setBean_DAO_Vote_Article_I(DAO_Vote_Article_I bean_DAO_Vote_Article_I)
            {
                this.bean_DAO_Vote_Article_I = bean_DAO_Vote_Article_I;
            }
//      Bean Injection  .................................................        
        
        String voteArticleCustMessage = null;//values will set inside Update and save mehtod.
        
        private ArticlesVotes vote_obj_New = null;//means the new vote, user has given now.
            private int vote_new_articleID  = 0 ; 
            private int vote_new_userID     = 0 ;
            private int vote_new_value      = 0 ;
        
        private ArticlesVotes vote_obj_stored = null;
            private int vote_stored_value = 200 ;
        
        private Articles_Insert articles_voted = null;//the article that has been given vote. taken as insert to get the article owner userID
            private int articles_OwnerID    = 0 ;
            private int articles_upVote     = 0 ;
            private int articles_downVote   = 0 ;
        
        private Users user_obj_as_ArticleOwner   = null ;
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
        public String services_vote_Articles(ArticlesVotes articlesVotes_New)
            {
                vote_obj_New = articlesVotes_New;//means the new vote, user has given now.
                    vote_new_articleID  = vote_obj_New.getVote_articleID();
                    vote_new_userID     = vote_obj_New.getVote_userID();
                    vote_new_value      = vote_obj_New.getVoteValue();

//                    Date Insertion for vote count.
                vote_obj_New.setVoteDate(GetDate.getDate());
                    
                vote_obj_stored = getBean_DAO_Vote_Article_I()
                        .dao_vote_getStoredArticle_Vote(vote_new_userID, vote_new_articleID, vote_new_value);

                if( vote_obj_stored != null )
                  {
                    vote_stored_value = vote_obj_stored.getVoteValue();
                  }

                articles_voted = getBean_DAO_Vote_Article_I().dao_vote_getArticleForVote(vote_new_articleID);
                    articles_OwnerID    = articles_voted.getUserID_articleByUser();
                    articles_upVote     = articles_voted.getArticleUpvote();
                    articles_downVote   = articles_voted.getArticleDownvote();
                    
                user_obj_as_ArticleOwner = getBean_DAO_Vote_Article_I().dao_vote_getUserAs_Article_Owner(articles_OwnerID);
                    user_totalUpVote    = user_obj_as_ArticleOwner.getTotalUpVote();
                    user_totalDownVote  = user_obj_as_ArticleOwner.getTotalDownVote();
                    user_totalVote      = user_obj_as_ArticleOwner.getTotalVote();
                    user_profileWeight  = user_obj_as_ArticleOwner.getProfileWeight();
                       
//                Stored    &&  new
//                1.                    null   &&                     -1
                if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) )
                  {
                    System.out.println(" \n if( (vote_obj_stored == null ) && ( vote_new_value == -1 ) ) \n");
                    
                    operations_DownVote();
                    saveArticleVote();
                  }
//                2.                    null   &&                      1
                if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) )
                  {
                    System.out.println("\n if( (vote_obj_stored == null ) && ( vote_new_value ==  1 ) ) \n");
                    
                    operations_UpVote();
                    saveArticleVote();
                  }
//                3.                       0  &&                     -1
                if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) )
                  {
                    System.out.println("\n if( (vote_stored_value ==  0) && ( vote_new_value == -1 ) ) \n");
                    
                    operations_DownVote();
                    vote_obj_stored.setVoteValue(-1);
                    updateArticleVote();
                  }
//                4.                       0  &&                      1
                if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) )
                  {
                    System.out.println("\n if( (vote_stored_value ==  0) && ( vote_new_value ==  1 ) ) \n");
                    
                    operations_UpVote();
                    vote_obj_stored.setVoteValue(1);
                    updateArticleVote();
                  }
//                5.                       1  &&                     -1
                if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )    
                  {
                    System.out.println("\n if( (vote_stored_value ==  1) && ( vote_new_value == -1 ) )     \n");
                    
//here total vote will not be increased.caz total vote already increased.
                    increase_DownVote_Article();
                    increase_DownVote_Users();
                    
                    decrease_Upvote_Article();
                    decrease_UpVote_Users();
                    
                    setProfileWeight_Users();
                    
                    vote_obj_stored.setVoteValue(-1);
                    updateArticleVote();
                  }
//                6.                       1  &&                      1
                if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) )
                  {
                    System.out.println("\n if( (vote_stored_value ==  1) && ( vote_new_value ==  1 ) ) \n");
                    
                    decrease_Upvote_Article();
                    decrease_UpVote_Users();
                    
                    decrease_TotalVote_Users();
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateArticleVote();
                  }
//                7.                      -1  &&                      1
                if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )    
                  {
                      System.out.println("if( (vote_stored_value == -1) && ( vote_new_value ==  1 ) )    ");
                     
                     increase_Upvote_Article();
                     increase_UpVote_Users();
                     
                     decrease_DownVote_Article();
                     decrease_DownVote_Users();
                     
                     setProfileWeight_Users();

                    vote_obj_stored.setVoteValue(1);
                    updateArticleVote();
                  }
//                8.                      -1  &&                     -1
                if( (vote_stored_value == -1) && ( vote_new_value == -1 ) )    
                  {
                    
                      System.out.println("if( (vote_stored_value == -1) && ( vote_new_value == -1 ) ) ");
                    
                    decrease_DownVote_Article();
                    decrease_DownVote_Users();
                    decrease_TotalVote_Users();
                    
                    setProfileWeight_Users();
                    vote_obj_stored.setVoteValue(0);
                    updateArticleVote();
                  }
                return voteArticleCustMessage;
            }

        private void increase_Upvote_Article()
            {
                articles_upVote = articles_upVote + 1;
                articles_voted.setArticleUpvote(articles_upVote);
            }

        private void increase_DownVote_Article()
            {
                articles_downVote += 1;
                articles_voted.setArticleDownvote(articles_downVote);
            }

        private void increase_UpVote_Users()
            {
                user_totalUpVote += 1;
                user_obj_as_ArticleOwner.setTotalUpVote(user_totalUpVote);
            }

        private void increase_DownVote_Users()
            {
                user_totalDownVote += 1;
                user_obj_as_ArticleOwner.setTotalDownVote(user_totalDownVote);
            }

        private void increase_TotalVote_Users()
            {
                user_totalVote = user_totalVote + 1;
                user_obj_as_ArticleOwner.setTotalVote(user_totalVote);
            }

        private void decrease_Upvote_Article()
            {
                System.out.println("upvote before articles_upVote:"+articles_upVote);
                articles_upVote -= 1;
                System.out.println("upvote after articles_upVote:"+articles_upVote);
                articles_voted.setArticleUpvote(articles_upVote);
            }

        private void decrease_DownVote_Article()
            {
                articles_downVote -= 1;
                articles_voted.setArticleDownvote(articles_downVote);
            }

        private void decrease_UpVote_Users()
            {
                System.out.println("upvote before user_totalUpVote:"+user_totalUpVote);
                user_totalUpVote -= 1;
                System.out.println("upvote before user_totalUpVote:"+user_totalUpVote);
                user_obj_as_ArticleOwner.setTotalUpVote(user_totalUpVote);
            }

        private void decrease_DownVote_Users()
            {
                user_totalDownVote -= 1;
                user_obj_as_ArticleOwner.setTotalDownVote(user_totalDownVote);
            }

        private void decrease_TotalVote_Users()
            {
                user_totalVote -= 1;
                user_obj_as_ArticleOwner.setTotalVote(user_totalVote);
            }

        private void setProfileWeight_Users()
            {
                user_profileWeight = (float) user_totalUpVote / user_totalVote;
                user_obj_as_ArticleOwner.setProfileWeight(user_profileWeight);
            }

        private void saveArticleVote()
            {
                 voteArticleCustMessage = getBean_DAO_Vote_Article_I()
                         .dao_save_article_vote(vote_obj_New, user_obj_as_ArticleOwner, articles_voted, "save");
            }

        private void updateArticleVote()
            {
                voteArticleCustMessage = getBean_DAO_Vote_Article_I()
                         .dao_save_article_vote(vote_obj_stored, user_obj_as_ArticleOwner, articles_voted, "update");
            }
        
        private void operations_DownVote()
            {
                //conditions : 1, 3, (5 bt 5 will not.changed later)
                increase_DownVote_Article();
                increase_DownVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
        private void operations_UpVote()
            {
                //conditions : 2, 4, (7 not caz it will increase the total vote unnecssaryly.)
                increase_Upvote_Article();
                increase_UpVote_Users();
                increase_TotalVote_Users();
                setProfileWeight_Users();
            }
    }
