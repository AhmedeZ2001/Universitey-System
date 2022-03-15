/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.student;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Ahmed Abdelnaser
 */
public class studentdb {
      public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Unviresity.db");
    }
       public static void insert(String fname,String lname, String add, String dept) {
        try {
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("insert into student(fname,lname,adress,department) values(?,?,?,?) ");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, add);
            ps.setString(4, dept);
            ps.execute();
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
        public static ArrayList<student> get_Data(String d) {
        ArrayList<student> students = new ArrayList();
        try {

            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("select * from student where department = ?");
            ps.setString(1, d);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                students.add(new student(r.getString("fname"), r.getString("lname"), r.getString("department"),r.getInt("id"),r.getString("department")));
            }
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }

    public static ArrayList<student> get_mark(String depart) {
     ArrayList<student> students = new ArrayList();
        try {

            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("select * from student,degree where student.Id=degree.id and department = ?");
            ps.setString(1, depart);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                students.add(new student(r.getInt("id"),r.getString("fname"),r.getString("lname"),r.getString("sum"),r.getString("department")));
            }
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }

    
}
