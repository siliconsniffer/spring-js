package com.example.demo;

public class ImageDTO {

    private String name;

    @Override
    public String toString() {
        return "ImageDTO{" +
                "name='" + name + '\'' +
                '}';
    }
    public ImageDTO(){
        System.out.println("constructor called");

    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageDTO(String name){
        this.name = name;
        System.out.println("Constructor with param");
    }
}
