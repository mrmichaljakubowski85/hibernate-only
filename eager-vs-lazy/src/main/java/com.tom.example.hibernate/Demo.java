package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Course;
import com.tom.example.hibernate.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Demo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();


//            Query<Instructor> query = session.createQuery(
//                    "select i from Instructor i"
//                            + " join fetch i.courses"
//                            + " where i.id = :instructorId",
//                    Instructor.class);
//            query.setParameter("instructorId", 1);
//
//            Instructor instructor = query.getSingleResult();

            Instructor instructor = session.get(Instructor.class, 1);
            for (Course cours : instructor.getCourses()) {

            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }


}
