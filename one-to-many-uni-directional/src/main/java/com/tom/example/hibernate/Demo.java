package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        Instructor instructor = null;
        try {
            session.beginTransaction();


            instructor = session.get(Instructor.class, 25);



            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

        System.out.println("XXX: " + instructor);
    }


}
