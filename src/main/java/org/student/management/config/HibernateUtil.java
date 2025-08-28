package org.student.management.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return SessionFactoryHolder.INSTANCE;
    }

    public static void shutdown() {
        SessionFactory sf = SessionFactoryHolder.INSTANCE;
        if (sf != null && !sf.isClosed()) {
            sf.close();
        }
    }

    private static class SessionFactoryHolder {
        private static final SessionFactory INSTANCE = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                // Loads default "hibernate.cfg.xml" from the classpath.
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                return configuration.buildSessionFactory();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Failed to initialize SessionFactory: " + e.getMessage());
            }
        }
    }
}
