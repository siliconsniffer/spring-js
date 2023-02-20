package com.example.demo;

import org.springframework.data.annotation.Id;

public class Image {
    @Id
    public String name;
    public Image(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format(
                "Image[name='%s']",
                name);
    }
}
