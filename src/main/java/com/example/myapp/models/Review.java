package com.example.myapp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Review")
@Table(name = "user_reviews_wine")
public class Review {
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User reviewer;
	
	@ManyToOne
	@JoinColumn(name = "wine_id", nullable = false)
	private Wine reviewed;
	
	@Column(name = "reviewer_rating", nullable = false)
	private boolean reviewerRating;
	
	public Review() {}
	
	public Review(User reviewer, Wine reviewed, boolean reviewerRating) {
		this.reviewer = reviewer;
		this.reviewed = reviewed;
		this.reviewerRating = reviewerRating;
		this.id = Objects.hash(this.reviewer.getUserId(), this.reviewed.getWineId());
	}
	
	public final int getId() { return this.id; }
	public final void setId(int id) { this.id = id; }
	
	public final User getReviewer() { return this.reviewer; }
	public final void setReviewer(User user) { this.reviewer = user; }
	
	public final Wine getReviewed() { return this.reviewed; }
	public final void setReviewed(Wine wine) { this.reviewed = wine; }
	
	public final boolean getReviewerRating() { return this.reviewerRating; }
	public final void setReviewerRating(boolean rating) { this.reviewerRating = rating; }
}
