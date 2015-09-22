package br.com.synchro.handson.test.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author cvs
 * @create Feb 9, 2015
 */
public class HibernateUtil {

    private static SessionFactory sf;
    private static Configuration configuration;

    static {
	buildSessionFactory();
    }

    /**
     * @throws HibernateException
     */
    @SuppressWarnings("deprecation")
    public static void buildSessionFactory() throws HibernateException {
	if (sf == null) {
	    try {
		configuration = new Configuration().configure();
		sf = configuration.buildSessionFactory();
	    } catch (final HibernateException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * @return sessionfactory
     * @throws HibernateException
     */
    public static SessionFactory getSessionFactory() throws HibernateException {
	if (sf == null || sf.isClosed()) {
	    buildSessionFactory();
	}
	return sf;
    }

}
