package com.jg.twitter.service;

import com.jg.twitter.persistance.DAO.ArticleDAO;

import java.util.List;

public class ArticleService {

    private ArticleDAO articleDAO = new ArticleDAO();

    public List getArticles() {
        return articleDAO.getArticles();
    }

}
