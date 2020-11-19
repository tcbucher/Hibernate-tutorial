package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo
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
            Student tempStudent = new Student("John", "Doe", "johnnyd@hotmail.co.uk");

            //Start transaction
            session.beginTransaction();

            //save the student
            session.save(tempStudent);

            // commit the transaction
            // We can also rollback if something went wrong
            session.getTransaction().commit();
        }

    }
}
