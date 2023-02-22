package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
public class HelloController {

    @GetMapping("api/images")
    public ImageResponse helloWorld(){
        System.out.println(imageRepository.toString());
        long imageNumber = imageRepository.count();
        String arr [] = new String[(int)imageNumber];
        List<Image> allImages = imageRepository.findAll();
        for (int i=0; i<imageNumber;i++){
            arr[i] = allImages.get(i).getId() + "." + allImages.get(i).getFileformat();
        }
        return new ImageResponse(arr);
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

        System.out.println(userData);
        User user = repository.findByUserName(userData.getUserNameOrEmail());
        if (user == null) {
            user = repository.findByEmail(userData.getUserNameOrEmail());
        }
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
    @Autowired
    private ImageRepository imageRepository;
    @RequestMapping(value = "/api/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile uploadedFile, ModelMap modelMap) throws IOException {
        System.out.println("File uploaded");
        //modelMap.addAttribute("file", file);//

        String[] filename = uploadedFile.getOriginalFilename().split("\\.");
        String name = filename[0];
        String fileformat = filename[1];
        Image savedImage = imageRepository.save(new Image(name, fileformat));
        File file = new File("/home/linus/Downloads/Git/backend/src/main/resources/images/"+ savedImage.getId() + "." + savedImage.getFileformat());
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(uploadedFile.getBytes());
        }
        return "File uploaded.";
    }
}