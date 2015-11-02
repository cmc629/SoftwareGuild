/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Date;

/**
 *
 * @author Christian Choi
 */
public class FacebookAccount {
    
//    public static int staticMethod(){
//        this.name = "Bill";
//        getName();
//    } this is not allowed
    
    
    private String name;
    private String email;
    private String password;
    private Date birthday;
    private Date dateCreated;
    private Date dateLastLogin;
    
    public FacebookAccount() {
        
    }
    
    
    public FacebookAccount(String name) {
        this.name = name;
    }

    public void doStuff() {
        
        this.name = "Bill";
        getName();
    }
    
    
    public void printName() {
        System.out.println(this.name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastLogin() {
        return dateLastLogin;
    }

    public void setDateLastLogin(Date dateLastLogin) {
        this.dateLastLogin = dateLastLogin;
    }
    
    
    
}
