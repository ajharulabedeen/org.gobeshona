/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.concrete.dao;

import org.gobeshona.concrete.entity.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell-3460
 */
public interface Article_I_CRUD_Repo extends CrudRepository<Article, Long>
    {
        List<Article> findAll();
    }
