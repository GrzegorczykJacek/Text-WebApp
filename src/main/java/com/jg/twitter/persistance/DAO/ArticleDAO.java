package com.jg.twitter.persistance.DAO;


import com.jg.twitter.persistance.HibernateUtil;
import com.jg.twitter.persistance.entities.TbArticle;
import com.jg.twitter.persistance.entities.TbUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleDAO {
    public List getArticles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            final Query query = session.createQuery("select o from TbArticle o");
            session.getTransaction().commit();
            return query.getResultList();
        }
    }

    public void addArticle(TbUser tbUser, String content) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            final TbArticle tbArticle = new TbArticle();
            tbArticle.setUser(tbUser);
            tbArticle.setContent(content);
            session.save(tbArticle); // save() method saves objects mapped to database without additional queries
            session.getTransaction().commit();

        }
    }
}
