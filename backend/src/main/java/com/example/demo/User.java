package com.example.demo;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    private String email;
    private String userName;
    private String password;

    public User() {}

    public User(String email, String userName, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s' userName='%s', password='%s']",
                id, email, userName, password);
    }
}