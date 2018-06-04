package com.booking.service;

import java.util.List;

import com.booking.entity.Review;

public interface ReviewService {

	Review getReviewById(int reviewId);

	List<Review> getAllReviews();

	boolean addReview(Review review);

	void updateReview(Review review);

	void deleteReview(int reviewId);

}
