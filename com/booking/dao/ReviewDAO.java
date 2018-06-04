package com.booking.dao;

import java.util.List;

import com.booking.entity.Customer;
import com.booking.entity.Hotel;
import com.booking.entity.Review;

public interface ReviewDAO {

	Review getReviewById(int reviewId);

	List<Review> getAllReviews();

	void addReview(Review review);

	void updateReview(Review review);

	void deleteReview(int reviewId);

	boolean ReviewExists(Customer customer, Hotel hotel);

}
