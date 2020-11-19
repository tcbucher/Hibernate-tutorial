package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryStudentDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        List<Student> students;

        try (factory)
        {
            //Start transaction
            session.beginTransaction();

            //query the student
            Query<Student> query = session.createQuery("from Student where lastName = 'Howard'");
            students = query.getResultList();

            // commit the transaction
            // We can also rollback if something went wrong
            session.getTransaction().commit();
        }

        for (Student student: students)
        {
            System.out.println("Student info: " + student.getId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Email Address: " + student.getEmail());
            System.out.println();
        }
    }
}
