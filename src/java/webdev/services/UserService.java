package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import webdev.models.User;
import webdev.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired //instantiate and hold
	UserRepository userRepository;

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
}
