package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

    public Name findByName(String Name);

}