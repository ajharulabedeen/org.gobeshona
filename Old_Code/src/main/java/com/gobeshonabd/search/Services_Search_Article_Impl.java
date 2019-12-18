/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import java.util.List;

/**
 *
 * @author Dell-3460
 */
public class Services_Search_Article_Impl implements Services_Search_Article_I
    {

//    Start Bean : ***************************************************
    private DAO_Search_Article_I bean_dao_Search_Article_I;
    public DAO_Search_Article_I getBean_dao_Search_Article_I()
        {
            return bean_dao_Search_Article_I;
        }
    public void setBean_dao_Search_Article_I(DAO_Search_Article_I bean_dao_Search_Article_I)
        {
            this.bean_dao_Search_Article_I = bean_dao_Search_Article_I;
        }
//    End Bean : ***************************************************    
        
        @Override
        public List services_search_article(String searchStringArticle, String searchColumnNameArticle)
            {
                return bean_dao_Search_Article_I.dao_search_article(searchStringArticle, searchColumnNameArticle);
            }
    }
