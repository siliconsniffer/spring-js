package com.example.demo;

public class ImageResponse {
    private int number;
    private String[] images;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public ImageResponse(int number, String[] images) {
        this.number = number;
        this.images = images;
    }

}
