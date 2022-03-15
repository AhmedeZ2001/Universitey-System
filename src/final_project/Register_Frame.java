/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class Register_Frame extends JFrame implements ActionListener {

    Image i = new Image();
    String depat;
    JTextField name = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel name1 = new JLabel("User Name : ");
    JLabel pass1 = new JLabel("Password  : ");
    JLabel dept = new JLabel("Department  : ");
    JButton signup = new JButton("Sign Up");
    JButton back = new JButton("Back");
    JRadioButton cs = new JRadioButton("CS");
    JRadioButton ds = new JRadioButton("DS");
    JRadioButton it = new JRadioButton("IT");
    JRadioButton is = new JRadioButton("IS");
    JRadioButton ai = new JRadioButton("AI");
    ButtonGroup g1 = new ButtonGroup();

    public Register_Frame() {
    }

    public void design() {
        name1.setBounds(100, 10, 100, 25);
        pass1.setBounds(100, 60, 100, 25);
        name.setBounds(180, 13, 150, 20);
        pass.setBounds(180, 63, 150, 20);
        signup.setBounds(200, 200, 100, 25);
        back.setBounds(0, 0, 70, 20);
        dept.setBounds(20, 110, 100, 20);
        cs.setBounds(120, 110, 50, 20);
        is.setBounds(170, 110, 50, 20);
        ai.setBounds(220, 110, 50, 20);
        it.setBounds(270, 110, 50, 20);
        ds.setBounds(320, 110, 50, 20);
        dept.setForeground(Color.WHITE);
        g1.add(ai);
        g1.add(ds);
        g1.add(is);
        g1.add(it);
        g1.add(cs);
        i.add(name1);
        i.add(name);
        i.add(pass);
        i.add(pass1);
        i.add(signup);
        i.add(cs);
        i.add(it);
        i.add(ai);
        i.add(is);
        i.add(ds);
        i.add(dept);
        i.add(back);
        signup.addActionListener(this);
        back.addActionListener(this);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 282);
        this.setLocation(600, 400);
        this.add(i);
        this.setTitle("University System");
    }

    public void chkrb() {

        if (cs.isSelected()) {
            depat = "CS";
        } else if (is.isSelected()) {
            depat = "IS";
        } else if (ds.isSelected()) {
            depat = "DS";
        } else if (cs.isSelected()) {
            depat = "AI";
        } else if (it.isSelected()) {
            depat = "IT";
        } else {
            depat = "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            this.dispose();
            new Login_Frame().design();
        } else if (ae.getSource() == signup) {
            chkrb();
            database.userdb.insert(name.getText(), pass.getText(), depat);
            JOptionPane.showMessageDialog(null, "Registered Succesfuly ! ", "Succes", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new Login_Frame().design();
        }
    }
}
