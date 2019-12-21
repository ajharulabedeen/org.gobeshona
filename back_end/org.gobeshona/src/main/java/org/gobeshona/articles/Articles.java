/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.articles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a")
    , @NamedQuery(name = "Articles.findByArticleId", query = "SELECT a FROM Articles a WHERE a.articleId = :articleId")
    , @NamedQuery(name = "Articles.findByArticleSubject", query = "SELECT a FROM Articles a WHERE a.articleSubject = :articleSubject")
    , @NamedQuery(name = "Articles.findByArticleUpVote", query = "SELECT a FROM Articles a WHERE a.articleUpVote = :articleUpVote")
    , @NamedQuery(name = "Articles.findByArticleDownVote", query = "SELECT a FROM Articles a WHERE a.articleDownVote = :articleDownVote")
    , @NamedQuery(name = "Articles.findByArticleDate", query = "SELECT a FROM Articles a WHERE a.articleDate = :articleDate")
    , @NamedQuery(name = "Articles.findByArticleContent", query = "SELECT a FROM Articles a WHERE a.articleContent = :articleContent")
    , @NamedQuery(name = "Articles.findByArticleType", query = "SELECT a FROM Articles a WHERE a.articleType = :articleType")
    , @NamedQuery(name = "Articles.findByUseridarticlebyUser", query = "SELECT a FROM Articles a WHERE a.useridarticlebyUser = :useridarticlebyUser")})
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "article_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer articleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "article_subject")
    private String articleSubject;
    @Column(name = "article_up_vote")
    private Integer articleUpVote;
    @Column(name = "article_down_vote")
    private Integer articleDownVote;
    @Size(max = 255)
    @Column(name = "article_date")
    private String articleDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20000)
    @Column(name = "article_content")
    private String articleContent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "article_type")
    private String articleType;
    @Column(name = "user_id_article_by_User")
    private Integer useridarticlebyUser;

    public Articles() {
    }

    public Articles(Integer articleId) {
        this.articleId = articleId;
    }

    public Articles(Integer articleId, String articleSubject, String articleContent, String articleType) {
        this.articleId = articleId;
        this.articleSubject = articleSubject;
        this.articleContent = articleContent;
        this.articleType = articleType;
    }

    public Articles(String articleSubject, String articleContent, String articleType, Integer useridarticlebyUser) {
        this.articleSubject = articleSubject;
        this.articleContent = articleContent;
        this.articleType = articleType;
        this.useridarticlebyUser = useridarticlebyUser;
    }

    
    
    public Articles(String articleSubject, Integer articleUpVote, Integer articleDownVote, String articleDate, String articleContent, String articleType, Integer useridarticlebyUser) {
        this.articleSubject = articleSubject;
        this.articleUpVote = articleUpVote;
        this.articleDownVote = articleDownVote;
        this.articleDate = articleDate;
        this.articleContent = articleContent;
        this.articleType = articleType;
        this.useridarticlebyUser = useridarticlebyUser;
    }

    
    
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleSubject() {
        return articleSubject;
    }

    public void setArticleSubject(String articleSubject) {
        this.articleSubject = articleSubject;
    }

    public Integer getArticleUpVote() {
        return articleUpVote;
    }

    public void setArticleUpVote(Integer articleUpVote) {
        this.articleUpVote = articleUpVote;
    }

    public Integer getArticleDownVote() {
        return articleDownVote;
    }

    public void setArticleDownVote(Integer articleDownVote) {
        this.articleDownVote = articleDownVote;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Integer getUseridarticlebyUser() {
        return useridarticlebyUser;
    }

    public void setUseridarticlebyUser(Integer useridarticlebyUser) {
        this.useridarticlebyUser = useridarticlebyUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleId != null ? articleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gobeshona.articles.Articles[ articleId=" + articleId + " ]";
    }
    
}
