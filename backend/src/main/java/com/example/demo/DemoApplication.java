package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Demonstrationscode
		repository.deleteAll();

		repository.save(new Customer("Alice", "Test"));
		repository.save(new Customer("Bob","Andrew"));
		repository.save(new Customer("Lukas","Hagenauer"));

		for (Customer customer : repository.findAll()){
			System.out.println(customer);
		}

		Customer gefundenerUser = repository.findByFirstName("Alice");
		System.out.println("");
		System.out.println(gefundenerUser);


	}
}
