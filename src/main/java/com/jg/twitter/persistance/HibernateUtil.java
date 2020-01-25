package com.jg.twitter.persistance;

import com.jg.twitter.utils.EnvironmentVariableUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // belowe are the variables used in EnvironmentalVariableUtil
    private static final String HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";
    private static final String HIBERNATE_CONNECTION_USERNAME = "hibernate.connection.username";
    private static final String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            return new Configuration()
                    .setProperty(HIBERNATE_CONNECTION_URL,
                            EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_URL))
                    .setProperty(HIBERNATE_CONNECTION_USERNAME,
                            EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_USERNAME))
                    .setProperty(HIBERNATE_CONNECTION_PASSWORD,
                            EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_PASSWORD))
                    .configure()
                    .buildSessionFactory();
//        ServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
//        return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }

}
