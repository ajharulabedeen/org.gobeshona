package org.gobeshona.articles;

import org.gobeshona.configs.GetDate;
import org.gobeshona.articles.DAO_Articles_I;
import org.gobeshona.pojos.Articles;
import org.gobeshona.pojos.Articles_Concise_View;
import org.gobeshona.pojos.Articles_Insert;
import java.util.List;

public class Services_Articles_CRUD_Impl implements Services_Articles_CRUD_I
    {
//    Start bean area +++++++++++++++++++++++++++++++++++++++++++++++++++++    
//******************** Injection    ******************************************
    private DAO_Articles_I  dao_Articles_I;
 
    public DAO_Articles_I getDao_Articles_I()
      {
        return dao_Articles_I;
      }
    public void setDao_Articles_I(DAO_Articles_I dao_Articles_I)
      {
        this.dao_Articles_I = dao_Articles_I;
      }
//******************** Injection    ******************************************
    
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");
    
//    End bean area +++++++++++++++++++++++++++++++++++++++++++++++++++++    
    
    public Services_Articles_CRUD_Impl()
      {
        
      }

    @Override
//    public String services_PostArticle(Articles_Insert articlesToPost)
    public Articles_Insert services_PostArticle(Articles_Insert articlesToPost)
      {
        articlesToPost.setArticleDate(GetDate.getDate());
        return dao_Articles_I.dao_postArticle(articlesToPost);
      }

    @Override
    public String services_ArticleDelete(Articles articlesToDelete)
      {
        return dao_Articles_I.dao_deleteArticle(articlesToDelete);
      }

    @Override
    public String services_ArticlesUpdate(Articles articlesToUpdate)
      {
        return dao_Articles_I.dao_updateArticle(articlesToUpdate);
      }

    
    //This method is not complete. Have to create view.
    @Override
    public List<Articles_Concise_View> services_ReadAllArticlesWithOutContent()
      {
        return dao_Articles_I.dao_readAllArticlesWithOutContent();
      }

    
    @Override
    public List services_ReadSpecificArticle(int articleID)
      {
        return dao_Articles_I.dao_readSpecificArticle(articleID);
      }
        
    }
