package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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


    @Autowired
    private UserRepository repository;
    @PostMapping(
            path = "/api/user/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity handleBrowserSubmissions(@RequestBody UserDTO userData) throws Exception {

        /*System.out.println("Vorm Erstellen");
        UserDTO user = new UserDTO("test@gmx.de", "Test123");
        System.out.println(user);*/


        System.out.println(userData);
        User user = repository.findByUserName(userData.getEmail());
        if( user.password.equals(userData.getPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Login successful.", HttpStatus.OK);
    }
}

