package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Student tempStudent;

        try (factory)
        {
            //Start transaction
            session.beginTransaction();

            //get the student
            tempStudent = session.get(Student.class, 5);

            // commit the transaction
            // We can also rollback if something went wrong
            session.getTransaction().commit();
        }

        System.out.println("Student info: " + tempStudent.getId());
        System.out.println("First Name: " + tempStudent.getFirstName());
        System.out.println("Last Name: " + tempStudent.getLastName());
        System.out.println("Email Address: " + tempStudent.getEmail());

    }
}
