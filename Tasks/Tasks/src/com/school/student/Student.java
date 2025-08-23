package com.school.student;

public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
