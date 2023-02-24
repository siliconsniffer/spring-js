package com.example.demo;

import org.springframework.data.annotation.Id;

public class Image {
    private String name;
    private String fileformat;
    @Id
    private String id;

    public Image() {
    }
    public Image(String name, String fileformat) {
        this.name = name;
        this.fileformat = fileformat;
    }
    public Image(String name, String fileformat, String id) {
        this.name = name;
        this.fileformat = fileformat;
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format(
                "Image[name='%s', fileformat='%s', id=%s]",
                name,fileformat,id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileformat() {
        return fileformat;
    }

    public void setFileformat(String fileformat) {
        this.fileformat = fileformat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
