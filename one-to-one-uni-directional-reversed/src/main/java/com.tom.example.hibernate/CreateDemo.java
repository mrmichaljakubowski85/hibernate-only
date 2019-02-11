package com.tom.example.hibernate;

import com.tom.example.hibernate.entity.Instructor;
import com.tom.example.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor = new Instructor("Tomx", "Jakistama", "masafasfdilassadfadfsa");
            InstructorDetail instructorDetail = new InstructorDetail("http://bleble", "plywanie");
            instructorDetail.setInstructor(instructor);

            session.save(instructorDetail);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

    public void test() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("xxx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
