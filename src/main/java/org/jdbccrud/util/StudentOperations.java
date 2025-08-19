package org.jdbccrud.util;

import java.util.List;
import java.util.Scanner;

public abstract class StudentOperations {

    private static final Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        Student student;
        String name, phone, city;

        System.out.println("Enter Student Details to Add.");
        System.out.println("Enter Student Name: "); name = sc.nextLine();
        System.out.println("Enter Student Phone: "); phone = sc.next();
        System.out.println("Enter Student City: "); city = sc.next();
        student = new Student(name, phone, city);

        if (StudentDAO.create(student)) System.out.println("Student Added Successfully!");
        else System.out.println("Error Inserting Student!");
    }

    public static void updateStudent() {
        System.out.println("Enter Student ID:");
        int id = sc.nextInt(); sc.nextLine();

        Student student = StudentDAO.read(id);
        if (student == null) {
            System.out.println("Student Not Found!");
            return;
        }

        System.out.println(student);
        System.out.printf("%s%n%s%n%s ",
                "Enter field to Update:",
                " 1. Name\n 2. Phone\n 3. City\n",
                "  >"
        );
        int choice = sc.nextInt(); sc.nextLine();

        System.out.printf("Enter New %s:",
                choice == 1 ? "Name" :
                        choice == 2 ? "Phone Number" : "City"
        );
        String newValue = sc.nextLine();
        if(StudentDAO.update(id, choice + 1, newValue))
            System.out.println("Student Updated Successfully!");
        else System.out.println("Error Updating Student!");
    }

    public static void deleteStudent() {
        System.out.println("Enter Student ID to Delete:");
        int id = sc.nextInt(); sc.nextLine();

        if(StudentDAO.read(id) == null) {
            System.out.println("Student ID Not Found!");
            return;
        }

        if (StudentDAO.delete(id)) System.out.println("Student Deleted Successfully!");
        else System.out.println("Error Deleting Student!");
    }

    public static void displayTable() {
        List<Student> allStudents = StudentDAO.readAll();
        if (allStudents != null)
            allStudents.forEach(System.out::println);
        else System.out.println("No Students Found!");
    }

    public static void displayStudentById() {
        System.out.println("Enter Student ID:");
        int id = sc.nextInt(); sc.nextLine();

        Student student = StudentDAO.read(id);
        if (student != null) System.out.printf("Student Details:%n%s%n", student);
        else System.out.println("Student Not Found!");

    }
}
