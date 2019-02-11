package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Instructor;
import com.tom.example.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

//            Instructor instructor = session.get(Instructor.class, 1);

//            System.out.println("XXXXX: " + instructor);

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);

            System.out.println("XXXXX: " + instructorDetail);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }


}
