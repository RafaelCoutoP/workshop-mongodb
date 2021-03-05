package com.rafaelcdev.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcdev.workshopmongo.models.dto.UserDTO;
import com.rafaelcdev.workshopmongo.models.entities.User;
import com.rafaelcdev.workshopmongo.repositories.UserRepository;
import com.rafaelcdev.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll(){
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		Optional<User> result = userRepository.findById(id);
		User entity = result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
		return new UserDTO(entity);
	}
}
