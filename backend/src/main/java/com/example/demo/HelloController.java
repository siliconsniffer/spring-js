package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class HelloController {

    @GetMapping("api/images")
    public ImageResponse helloWorld(){
        return new ImageResponse(2, new String[]{"elefant.avif", "tiger.jpg", "nashorn.jpg"});
    }


    @GetMapping(value = "api/data/images")
    public @ResponseBody byte[] getImages(@RequestParam String image) throws IOException {
        Path path = Paths.get("/home/linus/Downloads/Git/backend/src/main/resources/images/" + image);
        byte[] data = Files.readAllBytes(path);
        return data;
    }

}

