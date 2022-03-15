/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class Login_Frame extends JFrame implements ActionListener {

    Image i = new Image();
    JTextField name = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel name1 = new JLabel("User Name : ");
    JLabel pass1 = new JLabel("Password  : ");
    JButton signin = new JButton("Login");
    JButton signup = new JButton("Register");

    public Login_Frame() {
    }

    public void design() {
        name1.setBounds(100, 10, 100, 25);
        pass1.setBounds(100, 60, 100, 25);
        name.setBounds(180, 13, 150, 20);
        pass.setBounds(180, 63, 150, 20);
        signin.setBounds(110, 100, 100, 25);
        signup.setBounds(280, 100, 100, 25);
        i.add(name1);
        i.add(name);
        i.add(pass);
        i.add(pass1);
        i.add(signin);
        i.add(signup);
        signin.addActionListener(this);
        signup.addActionListener(this);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 282);
        this.setLocation(600, 400);
        this.add(i);
        this.setTitle("University System");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signin) {
            int stat = database.userdb.chk(name.getText(), pass.getText());
            switch (stat) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Invalid User Name  ", "Warning", JOptionPane.WARNING_MESSAGE);
                    name.setText("");
                    pass.setText("");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Welcome Back " + name.getText(), "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    String dep =database.userdb.getDepart(name.getText());
                    new Doctor_Frame(dep).design();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Invalid Password  ", "Warning", JOptionPane.WARNING_MESSAGE);
                    name.setText("");
                    pass.setText("");
                    break;
            }
        } else if (ae.getSource() == signup) {
            this.dispose();
            new Register_Frame().design();
        }

    }

}
