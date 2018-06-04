package com.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.entity.Hotel;

@Transactional
@Repository
public class HotelDAOImpl implements HotelDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Hotel getHotelById(int hotelId) {
		return entityManager.find(Hotel.class, hotelId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getAllHotels() {
		String hql = "FROM Hotel as cust ORDER BY cust.hotelId";
		return (List<Hotel>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addHotel(Hotel hotel) {
		entityManager.persist(hotel);
	}
	@Override
	public void updateHotel(Hotel hotel) {
		Hotel cust = getHotelById(hotel.getHotelId());
		cust.setHotelName(hotel.getHotelName());
		cust.setHotelEmail(hotel.getHotelEmail());
		cust.setHotelAddress(hotel.getHotelAddress());
		entityManager.flush();
	}
	@Override
	public void deleteHotel(int hotelId) {
		entityManager.remove(getHotelById(hotelId));
	}
	@Override
	public boolean HotelExists(String hotelName) {
		String hql = "FROM Hotel as hot WHERE hot.hotelName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, hotelName)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
