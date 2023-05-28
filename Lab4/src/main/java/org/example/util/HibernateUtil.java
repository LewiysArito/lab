package org.example.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;//основной класс для работы с hibernate
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();//создаёт сессию
            ourSessionFactory = configuration.buildSessionFactory();//создаёт сессию
        } catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException{
        return ourSessionFactory.openSession();//вовзращение новой сессии
    }
    public static SessionFactory getSessionFactory(){return ourSessionFactory;}
}
