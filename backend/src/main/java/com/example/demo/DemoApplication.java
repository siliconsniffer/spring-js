package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ImageRepository imageRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Demonstrationscode
		repository.deleteAll();

		repository.save(new User("test@gmx.de", "Test", "Test123"));
		repository.save(new User("Bob","Andrew", "???"));
		repository.save(new User("Lukas","Hagenauer","Lukas123"));

		imageRepository.deleteAll();
		Image newImage = new Image("elefant", "avif");
		newImage.setId("63f4a23530cd337cb250eda0");
		imageRepository.save(newImage);
		imageRepository.save(new Image("nashorn", "jpg", "63f4a817a4a4cc75d77e3ebf"));
		imageRepository.save(new Image("tiger", "jpg", "63f4aa4d5715fd538530e835"));

		for (User user : repository.findAll()){
			System.out.println(user);
		}
		for (Image image : imageRepository.findAll()){
			System.out.println(image);
		}

	}
}
