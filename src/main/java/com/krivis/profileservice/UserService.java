package com.krivis.profileservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(long userId) {
		
		userRepository.deleteById(userId);
	}

	public Optional<User> getUserById(long userId) {
		
		return userRepository.findById(userId);
	}

}
