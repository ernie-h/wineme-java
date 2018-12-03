package com.example.myapp.services;

import com.example.myapp.models.Review;
import com.example.myapp.models.User;
import com.example.myapp.models.Wine;
import com.example.myapp.repositories.ReviewRepository;
import com.example.myapp.repositories.UserRepository;
import com.example.myapp.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
	
	@GetMapping("/api/user/{userId}/top/personality")
	public List<Wine> getWinesByPersonality(@PathVariable("userId") int userId) {
		User user = users.findById(userId).orElse(null);
		
		if (user == null) return null;
		
		List<Review> personalityReviews = (List<Review>) reviews.getReviewsByPersonality(user.getPersonality());
		List<Wine> reviewedWines = getWines(personalityReviews);
		
		Map<String, Integer> weights = calculateWeights(personalityReviews);
		Map<Wine, Integer> scores = calculateScores(reviewedWines, weights);
		
		for (Iterator<Wine> iterator = scores.keySet().iterator(); iterator.hasNext(); ) {
			Wine w = iterator.next();
			if (scores.get(w) < 0) scores.remove(w);
		}
		
		return new ArrayList<>(scores.keySet());
	}
	
	private <T> LinkedHashMap<T, Integer> sortByValue(Map<T, Integer> map) {
		List<Map.Entry<T, Integer>> entries = new LinkedList<>(map.entrySet());
		
		Collections.sort(entries, Comparator.comparing(Map.Entry::getValue));
		
		LinkedHashMap<T, Integer> res = new LinkedHashMap<>();
		for (Map.Entry<T, Integer> entry : entries) res.put(entry.getKey(), entry.getValue());
		
		return res;
	}
	
	private Map<Wine, Integer> calculateScores(List<Wine> reviewedWines, Map<String, Integer> weights) {
		Map<Wine, Integer> res = new HashMap<>();
		
		for (Wine wine : reviewedWines) {
			String desc = wine.getDescription();
			int score = 0;
			for (String word : weights.keySet()) {
				if (desc.contains(" " + word + " ")) {
					score += weights.get(word);
				}
			}
			res.put(wine, score);
		}
		
		return res;
	}
	
	private Map<String, Integer> calculateWeights(List<Review> reviewedWines) {
		Map<String, Integer> res = new HashMap<>();
		
		for (Review r : reviewedWines) {
			String[] description = r.getReviewed().getDescription().split(" ");
			for (String d : description) {
				int delta = r.getReviewerRating() ? 1 : -1;
				int weight = res.getOrDefault(d, 0) + delta;
				res.put(d, weight);
			}
		}
		
		return res;
	}
	
	private List<Wine> getWines(List<Review> reviews) {
		Set<Wine> res = new HashSet<>();
		
		for (Review r : reviews) {
			res.add(r.getReviewed());
		}
		
		return new ArrayList<>(res);
	}
}
