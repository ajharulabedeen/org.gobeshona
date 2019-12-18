package com.gobeshonabd.voting;

import com.gobeshonabd.pojos.Users;
import java.util.List;

public interface DAO_Generel_Vote_Save_Read_I
    {
        /**
         * This method will fetch data from the Vote table.
         * vote table name is preceded by of that main table.
         * <b>(may be articleVote, articleCommentVote, QuestionAndAnswarVote, QuestionAndAnswarCommentVote)</b>
         * 
         * @param uIDcIDvValue = UserID, ContentID(may be article, articleComment, QuestionAndAnswar, QuestionAndAnswarComment) all will be integer.
         * @param fieldName_uIDcIDvValue = field name of the values. in their class.
         * @param voteClassObject = name of the class that data will be fetched.(may be article, articleComment, QuestionAndAnswar, QuestionAndAnswarComment)
         * @return will return a list with element.
         * 
         */
        List dao_generel_vote_voteReader(List<Integer> uIDcIDvValue, List<String> fieldName_uIDcIDvValue,Object voteClassObject );
        /**
         * 
         * @param contentID     id of the content.(may be article, articleComment, QuestionAndAnswar, QuestionAndAnswarComment etc)
         * @param contentIDname the column name in content class that hold the content id as PK.
         * @param contentClass  class of the content.(may be article, articleComment, QuestionAndAnswar, QuestionAndAnswarComment)
         * @return   it will return a list with one object, then have to get that and can be converted into the class type that we send.
         * 
         */
        List dao_generel_vote_contentReader(int contentID, String contentIDname, Object contentClass);
        /**
         * 
         * It will read the data of a user and 
         * 
         * @param userID userId of the Users Table
         * @return a Users object. 
         */
        Users dao_vote_getUser_As_ContentOwner(int userID);
        /**
         * 
         * @param userVote it is object for vote table. have to pass the vote table type object that we want to update.
         * @param userProfileWithVoteData after a vote count user vote 
         *          value will be changed and to reflect that user object value will be changed and prepared for update.
         * @param contentVoteData content means it may be article, articleComment, QuestionAndAnswar, QuestionAndAnswarComment etc.
         * @param voteOperationName two operation name is possible one is "update" and "save". 
         *                          save = new vote, the content yet not be voted.
         *                          update = means an existing vote status is going to be changed.
         * @return as string it return a message that will indicate is it success or failed.
         */
        String custUserVoteData(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName);
    }
