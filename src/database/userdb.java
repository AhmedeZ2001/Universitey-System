/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.user;
import final_project.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class userdb {
    public static String s;

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Unviresity.db");
    }

    public static void insert(String name, String pass, String dept) {
        try {
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("insert into user values(?,?,?) ");
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, dept);
            ps.execute();
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static ArrayList<user> getData() {
        ArrayList<user> Users = new ArrayList();
        try {

            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("select * from user");
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                Users.add(new user(r.getString("user_name"), r.getString("password"), r.getString("department")));
            }
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Users;
    }

    public static int chk(String name, String password) {
        ArrayList<user> Users = getData();
        int x = 0;
        for (int i = 0; i < Users.size(); i++) {
            if (name.equals(Users.get(i).getName())) {
                if (password.equals(Users.get(i).getPass())) {
                    x = 1;
                    break;
                } else {
                    x = 2;
                    break;
                }

            } else {
                x = 0;
            }
        }

        return x;
    }
    public static String getDepart(String name){
        ArrayList<user> Users = getData();
        for (int i = 0; i < Users.size(); i++) {                   
         if(name.equalsIgnoreCase(Users.get(i).getName()))
            s= Users.get(i).getDept();
        }
        return s;
    }
}
