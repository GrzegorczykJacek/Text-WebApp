package com.jg.twitter.persistance.DAO;

import com.jg.twitter.exception.ImproperLoginCredentials;
import com.jg.twitter.persistance.HibernateUtil;
import com.jg.twitter.persistance.entities.TbUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDAO {

    public TbUser getUserByLogin(String login) throws ImproperLoginCredentials {
        // Commented HQL implementation
//        try(Session session = HibernateUtil.getSessionFactory()
//                .openSession()){
//            // HQL - Hibernate Query Language
//            // e - TbUser class type object
//            Query query = session.createQuery("select e from " + TbUser.class.getName() + " e where e.login =:username");
//            query.setParameter("username", login);
//            session.beginTransaction();
//            TbUser getSingleResult = (TbUser)query.getSingleResult();
//            session.getTransaction().commit();
//            return getSingleResult;
//        } catch (NoResultException e){
//            throw new ImproperLoginCredentials("Incorrect username");
//        } catch (NonUniqueResultException e){
//            throw new ImproperLoginCredentials("Many results");
//        }

        try (Session session = HibernateUtil.getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TbUser> query = builder.createQuery(TbUser.class);
            Root<TbUser> root = query.from(TbUser.class);
            query.select(root).where(builder.equal(root.get("userName"), login));
            Query<TbUser> query1 = session.createQuery(query);
            TbUser tbUser = query1.uniqueResult();
            return tbUser;
        } catch (NoResultException e) {
            throw new ImproperLoginCredentials("Incorrect username");
        } catch (NonUniqueResultException e) {
            throw new ImproperLoginCredentials("Many results");
        }

    }

}
