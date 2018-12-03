package com.example.myapp.repositories;

import com.example.myapp.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
	@Query("SELECT r FROM Review r")
	List<Review> getReviews();
	
	@Query("SELECT r FROM Review r WHERE r.reviewer=:reviewerId")
	List<Review> getAllByReviewer(@Param("reviewerId") int reviewerId);
	
	@Query("SELECT r FROM Review r WHERE r.reviewed=:reviewedId")
	List<Review> getAllByReviewed(@Param("reviewedId") int reviewedId);
}
