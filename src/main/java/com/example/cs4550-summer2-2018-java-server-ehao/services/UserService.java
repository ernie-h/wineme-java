package com.example.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.webdev.models.User;
import com.example.myapp.webdev.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired //instantiate and hold
					UserRepository userRepository;

	@PostMapping("/api/user")
	public User test(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
//	@PostMapping("/register")
//	public User register(@RequestBody User user) {
//		return userRepository.save(user);
//	}
//	@GetMapping
//	public User findUser(int id) {
//		return userRepository.findById(id);
//	}
}
