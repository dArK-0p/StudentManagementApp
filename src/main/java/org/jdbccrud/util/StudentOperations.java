package org.jdbccrud.util;

import java.util.Scanner;

public abstract class StudentOperations {

    public static void addStudent(Scanner sc) {
        Student student;
        String name, phone, city;

        System.out.println("Enter Student Details to Add.");
        System.out.println("Enter Student Name: "); name = sc.nextLine();
        System.out.println("Enter Student Phone: "); phone = sc.next();
        System.out.println("Enter Student City: "); city = sc.next();
        student = new Student(name, phone, city);
        // TODO: Inserting into DB.
    }

    // TODO: Updating Student.
    public static void updateStudent(Scanner sc, int sId) {
        Student student;
        System.out.println("Not yet Implemented");
    }

    // TODO: Deleting Student.
    public static void deleteStudent(int sId) {
        Student student;
        System.out.println("Not yet Implemented");
    }

    // TODO: Display of Full table with all details in tablular format.
    public static void displayTable() {
        //TODO: Print Table;
        System.out.println("Not yet Implemented");
    }

    // TODO: Condition to get from DB.
    public static void displayStudentById(int sId) {
        Student student = new Student();
        System.out.printf("Student Details:%n%s%n", student);
    }
}
