package org.jdbccrud.util;

import org.jdbccrud.core.PostgresDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class StudentDAO {

    public static boolean create(Student student) {
        boolean status = false;

        try(Connection con = PostgresDBConnection.connect()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students(sname, sphone, scity) VALUES (?,?,?)");
            ps.setString(1, student.sName());
            ps.setString(2, student.sPhone());
            ps.setString(3, student.sCity());

            ps.executeUpdate();

            status = true;
        } catch (SQLException e) {
            System.out.println("Error Connecting to DB:");
            e.printStackTrace();
        }

        return status;
    }

    public static Student read(int sId) {
        try(Connection con = PostgresDBConnection.connect()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE sid = ?");
            ps.setInt(1, sId);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                return new Student(
                    res.getInt("sid"),
                    res.getString("sname"),
                    res.getString("sphone"),
                    res.getString("scity")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error Connecting to DB:");
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> readAll() {
        try(Connection con = PostgresDBConnection.connect()) {
            Statement st = con.createStatement();

            ResultSet res =  st.executeQuery("SELECT * FROM students ORDER BY sid;");
            List<Student> students = new ArrayList<>();

            while(res.next()) {
                 students.add(new Student(
                         res.getInt("sid"),
                         res.getString("sname"),
                         res.getString("sphone"),
                         res.getString("scity")
                 ));
            }
            return students;
        } catch (SQLException e) {
            System.out.println("Error Connecting to DB:");
            e.printStackTrace();
        }
        return null;
    }

    public static boolean update(int sId, int columnId, String newValue) {
        boolean status = false;

        try(Connection con = PostgresDBConnection.connect()) {
            String columnName =
                    columnId == 2 ? "sname" :
                            columnId == 3 ? "sphone" : "scity";
            PreparedStatement ps = con.prepareStatement("UPDATE students SET " + columnName + " = ? WHERE sid = ?");
            ps.setString(1, newValue);
            ps.setInt(2, sId);

            ps.executeUpdate();

            status = true;
        } catch (SQLException e) {
            System.out.println("Error Connecting to DB:");
            e.printStackTrace();
        }

        return status;
    }

    public static boolean delete(int sId) {
        boolean status = false;

        try(Connection con = PostgresDBConnection.connect()) {

            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE sid = ?");
            ps.setInt(1, sId);

            ps.executeUpdate();

            status = true;
        } catch (SQLException e) {
            System.out.println("Error Connecting to DB:");
            e.printStackTrace();
        }

        return status;
    }
}
