package com.tushar.beanfile;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private Course course; // dependency
    private int age ;
    private List <String> phones;

    // Constructor injection for ID and Name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Setter injection for Course
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public void setPhones(List<String> phone) {
        this.phones = phone;
    }


    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name     : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Contacts  :"+ phones);
        course.showCourse();  // prints course name
    }
}
