package org.gobeshona.articles;

import org.gobeshona.configs.StatusRequestSingleton;
import org.gobeshona.pojos.StatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Controller_Comment_Articles_CRUD
    {
       @Autowired
        Services_Articles_Comments_CRUD_I bean_services_Articles_Comments_CRUD_I;
        
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
        
        @RequestMapping(value = "/postArticleComment", method = RequestMethod.POST)
        public ArticlesComments_Insert postArticleComment( @RequestBody ArticlesComments_Insert articlesCommentsToPost )
          {
            return bean_services_Articles_Comments_CRUD_I.services_postComment(articlesCommentsToPost);
          }
        
        @RequestMapping(value = "/deleteArticleComment", method = RequestMethod.DELETE)
        public StatusRequest deleteArticleComment( @RequestBody ArticlesComments articlesCommentsToDelete )
          {
              statusRequest.setOperationStatus(bean_services_Articles_Comments_CRUD_I.services_deleteComment(articlesCommentsToDelete));
              return statusRequest;
          }
        
        @RequestMapping(value = "/upadteArticleComment", method = RequestMethod.PUT)
        public StatusRequest upadteArticleComment( @RequestBody ArticlesComments articlesCommentsToUpadte )
          {
            statusRequest.setOperationStatus(bean_services_Articles_Comments_CRUD_I.services_updateComment(articlesCommentsToUpadte));
            return statusRequest;
          }
    }
