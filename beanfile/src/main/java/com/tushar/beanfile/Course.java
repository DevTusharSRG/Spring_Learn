package com.tushar.beanfile;

public class Course {
    private String courseName;
    
    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void showCourse() {
        System.out.println("Course: " + courseName);
    }
}
