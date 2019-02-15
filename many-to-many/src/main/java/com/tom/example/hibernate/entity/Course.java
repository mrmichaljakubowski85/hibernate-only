package com.tom.example.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST})
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST})
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private List<Student> students;

    public Course() {

    }

    public Course(String title) {
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (students == null)
            students = new ArrayList<>();
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                ", students=" + students +
                '}';
    }
}
