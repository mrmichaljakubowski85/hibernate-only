package com.tom.example.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";

        String user = "hbstudent";
        String pass = "hbstudentpassword";
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);
        props.setProperty("ssl", "false");
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl, props);
            conn.close();
            System.out.println("Connection successfully closed.");
        } catch (SQLException e) {
            System.out.println("Catch: " + e);
        }
    }
}
