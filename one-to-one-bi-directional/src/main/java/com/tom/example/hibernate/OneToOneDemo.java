package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Instructor;
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

//            InstructorDetail instructorDetail= session.get(InstructorDetail.class, 8);
//            session.delete(instructorDetail);
//            instructorDetail.getInstructor().setInstructorDetail(null);

//            Instructor instructor = session.get(Instructor.class, 7);
//            System.out.println("xxxx: " + instructor);

            Instructor instructor = session.get(Instructor.class, 2);
              session.delete(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }


}
