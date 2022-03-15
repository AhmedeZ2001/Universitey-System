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
public class user {
    private String name ,pass,dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public user(String name, String pass, String dept) {
        this.name = name;
        this.pass = pass;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "user{" + "name=" + name + ", pass=" + pass + ", dept=" + dept + '}';
    }
    
}
