/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.pojos.Search;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell-3460
 */
@RestController
public class Controller_search
    {
        
        @Autowired
        Service_Search_Users_I bean_service_Search_Users_I ;
        @Autowired
        Services_Search_Article_I bean_services_Search_Article_I;
        @Autowired
        Services_Search_QuestionAndAnswar_I bean_services_Search_QuestionAndAnswar_I;
        
        @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
        public List getSearchUser(@RequestBody Search searchUser_obj)
            {
                return bean_service_Search_Users_I.service_search_users(searchUser_obj.getSearchString(), searchUser_obj.getSearchColumnName());
            }
        
        @RequestMapping(value = "/searchArticle", method = RequestMethod.POST)
        public List getSearchArticle(@RequestBody Search searchArticle_obj)
            {
                return bean_services_Search_Article_I.services_search_article(searchArticle_obj.getSearchString(), searchArticle_obj.getSearchColumnName());
            }
        
        @RequestMapping(value = "/searchQuestionAndAnswar", method = RequestMethod.POST)
        public List getSearchQuestionAndAnswar(@RequestBody Search searchQuestionAndAnswar_obj)
            {
                return bean_services_Search_QuestionAndAnswar_I.services_search_QuestionAndAnswar(searchQuestionAndAnswar_obj.getSearchString(), searchQuestionAndAnswar_obj.getSearchColumnName());
            }
        
    }
