package com.example.demo;

import org.springframework.data.annotation.Id;


public class User {

    @Id
    public String id;

    public String userName;
    public String password;

    public User() {}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, userName='%s', password='%s']",
                id, userName, password);
    }

}