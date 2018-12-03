package com.example.myapp.services;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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
		userRepository.deleteById(id);
	}
	
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = userRepository.findById(userId);
		if(data.isPresent()) {
			User user = data.get();
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setPersonality(newUser.getPersonality());
			userRepository.save(user);
			return user;
		}
		return null;
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

	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());
		if(existingUser.isPresent()) {
			throw new IllegalArgumentException("Username is duplicate");
		}
		else {
			User currentUser = userRepository.save(user);
			session.setAttribute("user", currentUser);
		return currentUser;
		}
	}

	@PostMapping("/api/login")
	public User login(@RequestBody User user, HttpSession session) {
		User existingUser = (User) userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(existingUser != null) {
			session.setAttribute("user", existingUser);
			return existingUser;
		}
		else {
			throw new IllegalArgumentException("No user found with credentials.");
		}
	}

	@PutMapping("/api/profile")
	public User updateProfile(@RequestBody User newUser, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		int sessionUserId = sessionUser.getUserId();
		return this.updateUser(sessionUserId, newUser);
	}

	@GetMapping("/api/profile")
	public Optional<User> getProfile(HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		return userRepository.findById(currentUser.getUserId());
	}

	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
