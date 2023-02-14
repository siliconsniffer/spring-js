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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Demonstrationscode
		repository.deleteAll();

		repository.save(new User("test@gmx.de", "Test123"));
		repository.save(new User("Bob","Andrew"));
		repository.save(new User("Lukas","Hagenauer"));

		for (User user : repository.findAll()){
			System.out.println(user);
		}

		User gefundenerUser = repository.findByUserName("Alice");
		System.out.println(gefundenerUser);


	}
}
