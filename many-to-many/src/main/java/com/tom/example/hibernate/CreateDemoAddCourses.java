package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Course;
import com.tom.example.hibernate.entity.Instructor;
import com.tom.example.hibernate.entity.InstructorDetail;
import com.tom.example.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemoAddCourses {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();


            Student student = session.get(Student.class, 22);
//            System.out.println(student);
            Course course1 = new Course("ahahahhd asdfasfdas fsafdasf XXXXXXsadfasdfsAAAAAAA");
            course1.addStudent(student);

            session.save(course1);




//            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }


}
