package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory)
        {
            // Start transaction
            session.beginTransaction();

            // Update the students from the database
            session.createQuery("Delete from Student where lastName = 'Wall'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();
        }
    }
}
