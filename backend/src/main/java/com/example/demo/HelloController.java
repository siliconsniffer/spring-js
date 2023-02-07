package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("api/images")
    public ImageResponse helloWorld(){
        return new ImageResponse(2, new String[]{"Image1.png", "Image2.png"});
    }
}
