package com.jg.twitter.service;

import com.jg.twitter.persistance.DAO.ArticleDAO;
import com.jg.twitter.persistance.entities.TbUser;

import java.util.List;

public class ArticleService {

    private ArticleDAO articleDAO = new ArticleDAO();

    public List getArticles() {
        return articleDAO.getArticles();
    }

    public void addArticle(TbUser tbUser, String content) {
        articleDAO.addArticle(tbUser, content);
    }

    ;

}
