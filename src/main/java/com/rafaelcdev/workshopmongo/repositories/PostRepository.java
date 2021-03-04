package com.rafaelcdev.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafaelcdev.workshopmongo.models.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

}
