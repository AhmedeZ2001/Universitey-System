/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.*;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class print extends JPanel implements ActionListener{
    String depart;
    JTable table;
    JScrollPane s;
    ArrayList<domain.student> arr ;
    String header[] = {"id", "fname", "lname","sum","Department"};
    String data[][];
    JButton b= new JButton("print"); 

    public print(String depart) {
        this.depart=depart;
        design();
    }
 public void design() {
        arr = database.studentdb.get_mark(depart);
        data = new String[arr.size()][5];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = "" + arr.get(i).getId();
            data[i][1] = "" + arr.get(i).getFname();
            data[i][2] = "" + arr.get(i).getLname();
            data[i][3] = "" +arr.get(i).getAddress();
            data[i][4] = "" +arr.get(i).getDegree();


        }
        table=new JTable(data, header);
         s=new JScrollPane(table);
        s.setBounds(0,30,400,222);
        b.setBounds(100, 0,100, 20);
       
        add(b);
         add(s);
        b.addActionListener(this);
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
         DefaultTableCellRenderer v =new DefaultTableCellRenderer();
         v.setHorizontalAlignment(JLabel.CENTER);
         for(int i=0 ;i<table.getComponentCount();i++)
             table.getColumnModel().getColumn(i).setCellRenderer(v);
         table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() ==  b)
       {
        MessageFormat h=new MessageFormat("Student");
        MessageFormat n=new MessageFormat("Page 1");
        
        try{
            table.print(JTable.PrintMode.NORMAL,h,n);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
       }
        
    }
    
}
