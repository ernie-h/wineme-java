package java.webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.webdev.repositories.UserRepository;
import java.webdev.models.User;



@RestController
public class UserService {
	@Autowired //instantiate and hold
	UserRepository userRepository;

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
}
