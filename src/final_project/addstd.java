/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import database.studentdb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Ahmed Abdelnaser
 */
public class addstd extends JPanel implements ActionListener{
    JTextField fname = new JTextField();
    JTextField lname = new JTextField();
    JTextField address = new JTextField();
    JTextField dept = new JTextField();
    JLabel fname1 = new JLabel  ("First Name  : ");
    JLabel lname1 = new JLabel  ("Last Name   : ");
    JLabel dept1 = new JLabel   ("Department  : ");
    JLabel address1 = new JLabel("Address     : ");
    JButton signup = new JButton("ADD STUDENT");

    public addstd() {
        design();
    }
    public void design(){
        this.setLayout(null);
        fname1.setBounds(50, 50, 80, 25);
        lname1.setBounds(50, 80, 80, 25);
        address1.setBounds(50, 110, 80, 25);
        dept1.setBounds(50, 140, 80, 25);
        dept.setBounds(150, 143, 140, 20);
        address.setBounds(150, 113, 140, 20);
        lname.setBounds(150, 83, 140, 20);
        fname.setBounds(150, 53, 140, 20);
        signup.setBounds(160, 200, 120, 25);
        signup.addActionListener(this);
        this.add(signup);
        this.add(lname);
        this.add(fname);
        this.add(dept);
        this.add(address);
        this.add(lname1);
        this.add(fname1);
        this.add(dept1);
        this.add(address1);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == signup)
       {
           database.studentdb.insert(fname.getText(), lname.getText(), address.getText(), dept.getText());
           JOptionPane.showMessageDialog(null, "Student Add Succesfully! ", "Succes", JOptionPane.INFORMATION_MESSAGE);
           fname.setText("");
           lname.setText("");
           dept.setText("");
           address.setText("");
       }
    }
}
