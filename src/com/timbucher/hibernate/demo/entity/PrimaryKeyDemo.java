package com.timbucher.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyDemo
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
            List<Student> students = new ArrayList<>();
            students.add(new Student("Larry", "Fine", "Bonk@hotmail.com"));
            students.add(new Student("Shemp", "Howard", "nyuk@hotmail.com"));
            students.add(new Student("Moe", "Howard", "lookhereyou@hotmail.com"));

            session.beginTransaction();

            for (Student student : students)
            {
                session.save(student);
            }

            session.getTransaction().commit();
        }


    }
}
