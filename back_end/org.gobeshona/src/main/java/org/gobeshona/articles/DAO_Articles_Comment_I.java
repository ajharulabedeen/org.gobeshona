package org.gobeshona.articles;
public interface DAO_Articles_Comment_I
    {
//        String dao_postComment(ArticlesComments_Insert articlesCommentsToPost);
        ArticlesComments_Insert dao_postComment(ArticlesComments_Insert articlesCommentsToPost);
        String dao_deleteComment(ArticlesComments articlesCommentsToDelete);
        String dao_updateComment(ArticlesComments articlesCommentsToUpdate);
        ArticlesComments dao_readSpecificComment(int specificCommentID);
    }
