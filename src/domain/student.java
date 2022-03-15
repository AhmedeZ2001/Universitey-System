/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class student {
    private int id;
    private String fname,lname,address,degree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public student( String fname, String lname, String address,int id, String degree) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.degree = degree;
    }

    public student(int id, String fname, String lname, String address,String degree) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.degree=degree;
    }
    
    
}
