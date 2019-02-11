package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            session.delete(instructor);


            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }


}
