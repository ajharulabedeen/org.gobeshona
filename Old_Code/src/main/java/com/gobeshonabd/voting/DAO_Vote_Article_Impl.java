package com.gobeshonabd.voting;

import com.gobeshonabd.voting.Get_Bean_DAO_Generel_Vote_Save_Read_Impl;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.pojos.ArticlesVotes;
import com.gobeshonabd.pojos.Articles_Insert;
import com.gobeshonabd.pojos.Users;
import java.util.ArrayList;
import java.util.List;

public class DAO_Vote_Article_Impl 
        implements 
        DAO_Vote_Article_I,
        Get_Bean_DAO_Generel_Vote_Save_Read_Impl
    {
    
    public DAO_Vote_Article_Impl()
        {
        
        }

    /**
     * This method will read data from the vote table.
     * 
     * it will go to the Article Vote Table and will read
     * the entire data that userID,articleID,voteValue match with it.
     */
    @Override
    public ArticlesVotes dao_vote_getStoredArticle_Vote(int userID, int articleID, int voteValue)
        {
            ArticlesVotes articlesVotes = null;
//        test
            System.out.println("\n\n public ArticlesVotes dao_vote_getArticle_Vote(int userID, int articleID, int voteValue)");
            System.out.println("userID : "+userID);
            System.out.println("articleID : "+articleID);
            System.out.println("voteValue : "+voteValue);
//        test 

            List uIDcIDvValue = new ArrayList();
            uIDcIDvValue.add( 0, userID);
            uIDcIDvValue.add( 1, articleID);
            uIDcIDvValue.add( 2, voteValue);
            
            List fieldName_uIDcIDvValue = new ArrayList();
            fieldName_uIDcIDvValue.add("vote_userID");
            fieldName_uIDcIDvValue.add("vote_articleID");
            fieldName_uIDcIDvValue.add("voteValue");
            
            List listArticlesVotes =  bean_DAO_Generel_Vote_Save_Read_I.dao_generel_vote_voteReader(uIDcIDvValue, fieldName_uIDcIDvValue, new ArticlesVotes());
            System.out.println("\n\n dao :  List listArticlesVotes :"+listArticlesVotes.toString());
            if (listArticlesVotes.isEmpty() == false)
              {
                  System.out.println("\n if (listArticlesVotes.isEmpty() == false)");
                articlesVotes = (ArticlesVotes) listArticlesVotes.get(0);
              }
            return articlesVotes;
        }

    /**
     * This method will read data from the Users table; totalVote, upVote, downVote, profileWeight.
     * For this moment it read all data.
     */
    @Override
    public Users dao_vote_getUserAs_Article_Owner(int userID)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.dao_vote_getUser_As_ContentOwner(userID);
        }

    /**
     * This method will read data from the Article table; upVote,downVote 
     * Only reading votes not possible now.
     * for this moment it will read all for vote update.
     * 
     * it will use dao_generel_vote_contentReader.
     * Where article id and field list will be sent.
     */
    @Override
    public Articles_Insert dao_vote_getArticleForVote(int articleID)
        {   
            System.out.println("\n Articles_Insert articles=null; \n");
            List articlesList =  bean_DAO_Generel_Vote_Save_Read_I.dao_generel_vote_contentReader(articleID, "articleID", new Articles_Insert());
            Articles_Insert articles=null;
            System.out.println("\n Articles_Insert articles=null; \n");
            System.out.println(""+articlesList.size());
            if(articlesList.isEmpty() == false)
              {
                 articles = (Articles_Insert) articlesList.get(0);
              }
            
            return articles;
        }

    /**
     * This method will save if new vote given
     * update if stored vote valued changed.
     * from service all objects will be provided.
     * 
     * @param userVote the vote with content id, userID and vote type.
     * @param userProfileWithVoteData the user who has given the vote.
     * @param contentVoteData the content that have been voted.
     * @param voteOperationName is it a new vote or have to update an existing vote.
     * @return a message will describe does the vote counted or not, does all transection about vote done or not.
     */
    @Override
    public String dao_save_article_vote(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName)
        {
            return bean_DAO_Generel_Vote_Save_Read_I.custUserVoteData(userVote, userProfileWithVoteData, contentVoteData, voteOperationName);
        }
    }
