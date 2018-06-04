package com.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.entity.Customer;
import com.booking.entity.Hotel;
import com.booking.entity.Review;

@Transactional
@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Review getReviewById(int ReviewId) {
		return entityManager.find(Review.class, ReviewId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getAllReviews() {
		String hql = "FROM Review as rev ORDER BY rev.reviewId";
		return (List<Review>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addReview(Review review) {
		entityManager.persist(review);
	}
	@Override
	public void updateReview(Review review) {
		Review rev = getReviewById(review.getReviewId());
		rev.setReviewTitle(review.getReviewTitle());
		rev.setReviewComment(review.getReviewComment());
		rev.setReviewRating(review.getReviewRating());
		rev.setCustomer(review.getCustomer());
		rev.setHotel(review.getHotel());
		entityManager.flush();
	}
	@Override
	public void deleteReview(int reviewId) {
		entityManager.remove(getReviewById(reviewId));
	}
	@Override
	public boolean ReviewExists(Customer customer, Hotel hotel) {
		String hql = "FROM Review as rev WHERE rev.customer = ? and rev.hotel = ?";
		int count = entityManager.createQuery(hql).setParameter(1, customer)
				.setParameter(2, hotel).getResultList().size();
		return count > 0 ? true : false;
	}
}
