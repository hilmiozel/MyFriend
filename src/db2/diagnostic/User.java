/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2.diagnostic;

/**
 *
 * @author Rasit
 * Bu class ı user bilgilerini tutmak için oluşturacak.
 */
public class User {
    String email;
    String password;
    String name;
    String surname;
    boolean auth=false; 

    public User(String email, String password, String name, String surname, boolean auth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.auth = auth;
    }

    public User() {
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
    public Boolean getAuth() {
        return auth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }
    
    
    
}
