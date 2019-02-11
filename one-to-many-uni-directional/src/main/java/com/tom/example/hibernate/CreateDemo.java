package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Course;
import com.tom.example.hibernate.entity.Instructor;
import com.tom.example.hibernate.entity.InstructorDetail;
import com.tom.example.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor = new Instructor("Tomx", "Jakistama", "maisasasfddfaddfasdfalsadfasdfsa");
            InstructorDetail instructorDetail = new InstructorDetail("http://bleble", "plywanie");
            instructor.setInstructorDetail(instructorDetail);


            Course course1 = new Course("tytul1xaasfdasffasfdsfdax");
            Course course2 = new Course("tytul2sassafdfdfafasfdxx");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            course1.addReview(new Review("super1_1"));
            course1.addReview(new Review("super1_2"));

            course2.addReview(new Review("great2_1"));

            session.save(instructor);

            session.save(course1);
            session.save(course2);

//            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }


}
