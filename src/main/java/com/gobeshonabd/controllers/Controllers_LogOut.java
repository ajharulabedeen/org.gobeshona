package com.gobeshonabd.controllers;

import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.pojos.Articles;
import com.gobeshonabd.articles.Services_Articles_CRUD_I;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers_LogOut 
    {
        @RequestMapping( value = "/logoutsucess", method = RequestMethod.GET)
        public String getSpecificArticle(@RequestBody int specificArticleID)
          {
            return "logoutSuccess";
          }
    }
