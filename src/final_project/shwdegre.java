/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class shwdegre extends JPanel implements ActionListener{

    int id;
    int x;
    String depart;
    JTable table;
    JScrollPane s;
    ArrayList<domain.student> arr ;
    String header[] = {"id", "fname", "lname"};
    String data[][];
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();
    JLabel m1 = new JLabel("SE");
    JLabel m2 = new JLabel("OS");
    JLabel m3 = new JLabel("CA");
    JLabel m4 = new JLabel("AD");
    JLabel m5 = new JLabel("DB");
    JLabel m6 = new JLabel("DC");
    JButton b1=new JButton("add degree");
    JButton b2=new JButton("Refresh");

    public shwdegre( String depart) {
        this.depart=depart;
        this.setLayout(null);
        design();
        
    }

    public void design() {
         arr = database.studentdb.get_Data(depart);

        data = new String[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = "" + arr.get(i).getId();
            data[i][1] = "" + arr.get(i).getFname();
            data[i][2] = "" + arr.get(i).getLname();

        }
        table=new JTable(data, header);
         s=new JScrollPane(table);
        s.setBounds(0,0,250,150);
        m1.setBounds(260, 20, 80, 25);
        m2.setBounds(260, 50, 80, 25);
        m3.setBounds(260, 80, 80, 25);
        m4.setBounds(260, 110, 80, 25);
        m5.setBounds(260, 140, 80, 25);
        b2.setBounds(20, 150, 100, 20);
        m6.setBounds(260, 170, 80, 25);
        t1.setBounds(320, 20, 80, 25);
        t2.setBounds(320, 50, 80, 25);
        t3.setBounds(320, 80, 80, 25);
        t4.setBounds(320, 110, 80, 25);
        t5.setBounds(320, 140, 80, 25);
        t6.setBounds(320, 170, 80, 25);
        b1.setBounds(290, 220, 100, 20);
        b1.addActionListener(this);
        b2.addActionListener(this);
         this.add(s);
         this.add(m1);
         this.add(m2);
         this.add(m3);
         this.add(m4);
         this.add(m5);
         this.add(m6);
         this.add(b1);
         this.add(b2);
         this.add(t1);
         this.add(t2);
         this.add(t3);
         this.add(t4);
         this.add(t5);
         this.add(t6);
         ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
         DefaultTableCellRenderer v =new DefaultTableCellRenderer();
         v.setHorizontalAlignment(JLabel.CENTER);
         for(int i=0 ;i<table.getComponentCount();i++)
             table.getColumnModel().getColumn(i).setCellRenderer(v);
         table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
         table.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt)
             {
                 ttmouseClicked(evt);
             }
         });
    }
    private void ttmouseClicked(java.awt.event.MouseEvent evt){
        x=table.getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == b1){
            id=arr.get(x).getId();
       database.degreedb.insert(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()) , id);
       JOptionPane.showMessageDialog(null, "Grades Updtaed! ", "Succes", JOptionPane.INFORMATION_MESSAGE);
       t1.setText("");
       t2.setText("");
       t3.setText("");
       t4.setText("");
       t5.setText("");
       t6.setText("");
       }
       else if(ae.getSource() == b2)
       {
        design();
       }
    }
}
