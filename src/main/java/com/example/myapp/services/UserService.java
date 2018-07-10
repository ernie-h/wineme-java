package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);;
	}

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/api/user/{userId}")
	//maybe map user id as string. Cant be sure it is integer
	public User findUserById(@PathVariable("userId") int userId) {
		Optional<User> data = userRepository.findById(userId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = userRepository.findById(userId);
		if(data.isPresent()) {
			User user = data.get();
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setFirst_name(newUser.getFirst_name());
			user.setLast_name(newUser.getLast_name());
			user.setEmail(newUser.getEmail());
			user.setPhone(newUser.getPhone());
			user.setDate_of_birth(newUser.getDate_of_birth());
			user.setRole(newUser.getRole());
			userRepository.save(user);
			return user;
		}
		return null;
	}
	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());
		if(existingUser.isPresent()) {
			throw new IllegalArgumentException("Username is duplicate");
		}
		else {
			User currentUser = userRepository.save(user);
			session.setAttribute("currentUser", currentUser);
		return currentUser;
		}
	}
}
