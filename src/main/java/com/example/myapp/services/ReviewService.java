package com.example.myapp.services;

import com.example.myapp.models.Review;
import com.example.myapp.repositories.ReviewRepository;
import com.example.myapp.repositories.UserRepository;
import com.example.myapp.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewService {
	@Autowired
	ReviewRepository reviews;
	@Autowired
	UserRepository users;
	@Autowired
	WineRepository wines;
	
	@PostMapping("/api/user/{userId}/review/{wineId}/{didLike}")
	public Review createReview(@PathVariable("userId") int userId,
							   @PathVariable("wineId") int wineId,
							   @PathVariable("didLike") int didLike) {
		return reviews.save(new Review(
				users.findById(userId).orElse(null),
				wines.findById(wineId).orElse(null),
				didLike > 0
		));
	}
	
	@GetMapping("/api/review/all")
	public List<Review> getReviews()
}
