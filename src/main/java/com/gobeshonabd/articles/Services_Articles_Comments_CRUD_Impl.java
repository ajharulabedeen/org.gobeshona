package com.gobeshonabd.articles;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.articles.DAO_Articles_Comment_I;
import com.gobeshonabd.pojos.ArticlesComments;
import com.gobeshonabd.pojos.ArticlesComments_Insert;

public class Services_Articles_Comments_CRUD_Impl
        implements Services_Articles_Comments_CRUD_I
    {

//    Start bean area +++++++++++++++++++++++++++++++++++++++++++++++++++++
//******************** Injection    ******************************************
    private DAO_Articles_Comment_I dao_Articles_Comment_I;
    
    public DAO_Articles_Comment_I getDao_Articles_Comment_I()
      {
        return dao_Articles_Comment_I;
      }
    public void setDao_Articles_Comment_I(DAO_Articles_Comment_I dao_Articles_Comment_I)
      {
        this.dao_Articles_Comment_I = dao_Articles_Comment_I;
      }
//******************** Injection    ******************************************
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");
//    End bean area +++++++++++++++++++++++++++++++++++++++++++++++++++++    

    public Services_Articles_Comments_CRUD_Impl()
      {

      }

    

    @Override
    public ArticlesComments_Insert services_postComment(ArticlesComments_Insert articlesCommentsToPost)
      {
        articlesCommentsToPost.setCommentDate(GetDate.getDate());
        return getDao_Articles_Comment_I().dao_postComment(articlesCommentsToPost);
      }

    @Override
    public String services_deleteComment(ArticlesComments articlesCommentsToDelete)
      {
        return getDao_Articles_Comment_I().dao_deleteComment(articlesCommentsToDelete);
      }

    @Override
    public String services_updateComment(ArticlesComments articlesCommentsToUpdate)
      {
        return getDao_Articles_Comment_I().dao_updateComment(articlesCommentsToUpdate);
      }

    /**
     * I think this method is not needed. Have to review.
     *
     * @param specificCommentID
     * @return
     */
    @Override
    public ArticlesComments services_readSpecificComment(int specificCommentID)
      {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    }
