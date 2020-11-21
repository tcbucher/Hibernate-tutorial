package com.timbucher.hibernate.demo.relationship;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorDemo
{
    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    public static void main(String[] args)
    {
        // Create related objects
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "luv 2 code!!!");

        // Associate the related objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Session session = factory.getCurrentSession();

        try (factory)
        {
            session.beginTransaction();

            session.save(tempInstructor);

            session.getTransaction().commit();
        }
    }
}
