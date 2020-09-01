package com.krivis.profileservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/users")
	public User registerUser(@RequestBody User user) {
		System.out.println("User Data: "  + user.getFirstName() + "" + user.getLastName() + "" + user.getEmail());
		return userService.createUser(user);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable long userId) {
		System.out.println("=========== getUserById===========");
		Optional<User> user = userService.getUserById(userId);
		return user.get();
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long userId) {
    	userService.deleteUser(userId);
    }
	
}
