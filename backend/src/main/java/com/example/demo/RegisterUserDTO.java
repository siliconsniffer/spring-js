package com.example.demo;

public class RegisterUserDTO {

    private String userName;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public RegisterUserDTO(){
        System.out.println("constructor called");

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public RegisterUserDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}


