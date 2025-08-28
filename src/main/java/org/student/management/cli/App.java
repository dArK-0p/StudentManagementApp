package org.student.management.cli;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.student.management.config.HibernateUtil;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                // ... do work (persist, query, etc.)

                tx.commit();
                System.out.println("Data saved successfully.");
            } catch (Exception e) {
                if (tx != null && tx.getStatus().canRollback())
                    tx.rollback();
            }
        }
    }
}
