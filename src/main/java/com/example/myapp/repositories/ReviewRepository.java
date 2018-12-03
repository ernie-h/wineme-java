package com.example.myapp.repositories;

import com.example.myapp.models.MyersBriggs;
import com.example.myapp.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
	@Query("SELECT r FROM Review r")
	Iterable<Review> getReviews();
	
	@Query("SELECT r FROM Review r WHERE r.reviewer=:reviewerId")
	Iterable<Review> getAllByReviewer(@Param("reviewerId") int reviewerId);
	
	@Query("SELECT r FROM Review r WHERE r.reviewed=:reviewedId")
	Iterable<Review> getAllByReviewed(@Param("reviewedId") int reviewedId);
	
	@Query("SELECT r FROM Review r WHERE r.reviewer.personality=:mb")
	Iterable<Review> getReviewsByPersonality(@Param("mb") MyersBriggs mb);
}
