package gb.homeworks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtils {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void stop(){
        if (sessionFactory != null ){
            if (!sessionFactory.isClosed()){
                sessionFactory.close();
            }
        }
    }
}
