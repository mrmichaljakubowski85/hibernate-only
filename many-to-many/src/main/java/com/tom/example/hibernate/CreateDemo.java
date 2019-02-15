package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Course;
import com.tom.example.hibernate.entity.Instructor;
import com.tom.example.hibernate.entity.InstructorDetail;
import com.tom.example.hibernate.entity.Student;
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
            Student student1_1 = new Student("Tom", "Ble", "mail");
            course1.addStudent(student1_1);
            Student student1_2 = new Student("Tomasdfas", "Ble", "mail");
            course1.addStudent(student1_2);

            Course course2 = new Course("tytul2sassafdfdfafasfdxx");
            Student student2_1 = new Student("sfda", "fasfdas", "asdfasfd");
            course2.addStudent(student2_1);
            Student student2_2 = new Student("asfas", "adsfasdf", "zzzz");
            course2.addStudent(student2_2);
            Student student2_3 = new Student("asfsadfasas", "adsfasdf", "zzzzsadfasdf");
            course2.addStudent(student2_3);

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(instructor);

            session.save(course1);
            session.save(course2);

            session.save(student1_1);
            session.save(student1_2);
            session.save(student2_1);
            session.save(student2_2);
            session.save(student2_3);



//            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }


}
