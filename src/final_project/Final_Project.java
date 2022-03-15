/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class Final_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new Login_Frame().design();
        }
    
}
