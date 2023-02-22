package com.example.demo;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;
    public String email;
    public String userName;
    public String password;

    public User() {}

    public User(String email, String userName, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s' userName='%s', password='%s']",
                id, email, userName, password);
    }
}