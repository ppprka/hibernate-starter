package com.innowise.danko.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
            return sessionFactory;
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
