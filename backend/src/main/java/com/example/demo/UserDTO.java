package com.example.demo;

public class UserDTO {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDTO(){
        System.out.println("constructor called");

    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public UserDTO(String email, String password){
        this.email = email;
        this.password = password;
        System.out.println("Constructor with param");
    }
}


