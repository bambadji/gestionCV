package com.gestion.cv.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.cv.entites.User;
import com.gestion.cv.repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	
	
	@GetMapping
	@RequestMapping("/recherche/{id}")
	public User getUser(@PathVariable(name = "id") int userId) {
       System.out.println("Bonjour");
		Optional<User> op= userRepository.findById(userId);
		return op.get();
	}
	
	
	
	// FONTION 1
	
	@GetMapping
	@RequestMapping("/liste")
	public List<User> getAllUsers() {

		List<User> users = (List<User>) userRepository.findAll();

		return users;
	}
	
	
	// FONCTION 2
	@PostMapping
	@RequestMapping("/add")
	public User addUser( @RequestBody User user , @RequestHeader(name = "action") String action,@RequestParam(name = "typeUser") String typeUser) {
		user.setPassword(action);
		user.setPrenom(typeUser);
		userRepository.save(user);
		return user;
	}

}
