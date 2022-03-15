/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class degreedb {
       public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Unviresity.db");
    }
       public static void insert(int m1,int m2,int m3,int m4 ,int m5,int m6,int id){
           try {
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("insert into degree values(?,?,?,?,?,?,?,?) ");
            ps.setInt(1, m1);
            ps.setInt(2, m2);
            ps.setInt(3, m3);
            ps.setInt(4, m4);
            ps.setInt(5, m5);
            ps.setInt(6, m6);
            ps.setInt(7, id);
            ps.setInt(8, m1+m2+m3+m4+m5+m6);
            ps.execute();
            c.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
    
}
