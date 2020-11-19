package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Student student;

        try (factory)
        {
            // Start transaction
            session.beginTransaction();

            // Retrieve the student from the database
            student = session.get(Student.class, 4);

            // Update the student
            student.setFirstName("Curly");

            // Commit the transaction
            session.getTransaction().commit();
        }

            System.out.println("Student info: " + student.getId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Email Address: " + student.getEmail());
            System.out.println();

    }
}
