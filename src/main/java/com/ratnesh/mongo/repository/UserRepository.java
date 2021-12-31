package com.ratnesh.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratnesh.mongo.document.User;

public interface UserRepository extends MongoRepository<User, Integer> {
}
