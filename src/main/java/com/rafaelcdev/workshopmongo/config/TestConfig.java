package com.rafaelcdev.workshopmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafaelcdev.workshopmongo.models.entities.User;
import com.rafaelcdev.workshopmongo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository; 

	@PostConstruct
	public void init() {
	
		userRepository.deleteAll();
		
		User user1 = new User(null, "Rafael Couto", "rafaelcouto@hotmail");
		User user2 = new User(null, "Alex Brown", "alex@hotmail");
		User user3 = new User(null, "Maria Green", "maria@gmail");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}