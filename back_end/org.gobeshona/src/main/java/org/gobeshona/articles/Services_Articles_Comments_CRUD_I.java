/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.articles;

import org.gobeshona.pojos.ArticlesComments;
import org.gobeshona.pojos.ArticlesComments_Insert;

/**
 *
 * @author Dell-3460
 */
public interface Services_Articles_Comments_CRUD_I
    {
//        String services_postComment(ArticlesComments_Insert articlesCommentsToPost);
        ArticlesComments_Insert services_postComment(ArticlesComments_Insert articlesCommentsToPost);
        String services_deleteComment(ArticlesComments articlesCommentsToDelete);
        String services_updateComment(ArticlesComments articlesCommentsToUpdate);
        ArticlesComments services_readSpecificComment(int specificCommentID);
    }
