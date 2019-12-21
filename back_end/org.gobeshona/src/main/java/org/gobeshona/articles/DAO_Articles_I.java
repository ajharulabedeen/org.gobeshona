/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.articles;

import org.gobeshona.pojos.Articles;
import org.gobeshona.pojos.Articles_Concise_View;
import org.gobeshona.pojos.Articles_Insert;
import java.util.List;

/**
 *
 * @author Dell-3460
 */
public interface DAO_Articles_I 
{
//    String   dao_postArticle(Articles_Insert articleToPost);
    Articles_Insert   dao_postArticle(Articles_Insert articleToPost);
    String   dao_deleteArticle(Articles articleToDelete );
    String   dao_updateArticle(Articles articleToUpdate );
    List dao_readAllArticlesWithOutContent();
    List dao_readSpecificArticle(int articleID);
}
