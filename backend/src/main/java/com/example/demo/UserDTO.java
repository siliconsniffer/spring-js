package com.example.demo;

public class UserDTO {

    private String userNameOrEmail;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userNameOrEmail='" + userNameOrEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDTO(){
        System.out.println("constructor called");

    }

    public String getUserNameOrEmail() {
        return userNameOrEmail;
    }

    public void setUserNameOrEmail(String userNameOrEmail) {
        this.userNameOrEmail = userNameOrEmail;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public UserDTO(String userNameOrEmail, String password){
        this.userNameOrEmail = userNameOrEmail;
        this.password = password;
        System.out.println("Constructor with param");
    }
}


