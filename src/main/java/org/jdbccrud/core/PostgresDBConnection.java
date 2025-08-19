package org.jdbccrud.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/" + "student_manage";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres117";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            // System.out.println("Connected to PostgreSQL successfully!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found!", e);
        }
    }
}