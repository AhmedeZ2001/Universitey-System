/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import javax.swing.*;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class Doctor_Frame extends JFrame{
    String dept;
    JTabbedPane tab= new JTabbedPane();
    addstd std= new addstd();
    shwdegre deg;
    print p;
    public Doctor_Frame(String dept) {
        this.dept=dept;
    }
    public void design(){
        shwdegre deg=new shwdegre(dept);
        print p =new print(dept);
        
        tab.add("student",std);
        tab.add("Degree", deg);
        tab.add("print",p);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(428, 322);
        this.setLocation(600, 400);
        this.setTitle("Doctor");
         this.add(tab);
    }
    
    
}
