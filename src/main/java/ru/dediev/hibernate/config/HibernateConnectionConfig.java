package ru.dediev.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionConfig {
    public static SessionFactory factory;

    private HibernateConnectionConfig() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return factory;
    }
    public static synchronized Session getSession() {
        return getSessionFactory().openSession();
    }

}
