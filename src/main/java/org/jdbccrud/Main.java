package org.jdbccrud;

import org.jdbccrud.util.StudentOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public void displayMenu() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        boolean exitToggle = true;

        while (exitToggle) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s ",
                    "1. Add Student",
                    "2. Update Student",
                    "3. Delete Student",
                    "4. Display All Students",
                    "5. Display Student by ID",
                    "6. Exit",
                    "Enter your choice: ");
            char choice = sc.next().charAt(0);

            switch(choice) {
                case '1' -> StudentOperations.addStudent(sc);
                case '2' -> StudentOperations.updateStudent(sc, 0);
                case '3' -> StudentOperations.deleteStudent(0);
                case '4' -> StudentOperations.displayTable();
                case '5' -> StudentOperations.displayStudentById(0);
                case '6' -> {
                    System.out.println("Exiting....");
                    exitToggle = false;
                }
                default -> System.out.println("Invalid Choice!\nRe-run Initiated....\n");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Welcome to Student Management System!!");
        try {
            main.displayMenu();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input format!!\nValid Input: 1-6.");
            System.out.printf("Exception: %s%n", e.getMessage());
        } finally {
            System.out.println("Thank You for using Student Management System!!");
        }
    }
}