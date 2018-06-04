package com.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.entity.Amenity;

@Transactional
@Repository
public class AmenityDAOImpl implements AmenityDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Amenity getAmenityById(int amenityId) {
		return entityManager.find(Amenity.class, amenityId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Amenity> getAllAmenitys() {
		String hql = "FROM Amenity as amen ORDER BY amen.amenityId";
		return (List<Amenity>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addAmenity(Amenity amenity) {
		entityManager.persist(amenity);
	}
	@Override
	public void updateAmenity(Amenity amenity) {
		Amenity amen = getAmenityById(amenity.getAmenityId());
		amen.setAmenityStars(amenity.getAmenityStars());
		amen.setAmenityRestaurant(amenity.getAmenityRestaurant());
		amen.setAmenityWifi(amenity.getAmenityWifi());
		amen.setAmenityAirconditioning(amenity.getAmenityAirconditioning());
		amen.setAmenityBreakfast(amenity.getAmenityBreakfast());
		amen.setAmenityPool(amenity.getAmenityPool());
		amen.setAmenityGym(amenity.getAmenityPool());
		entityManager.flush();
	}
	@Override
	public boolean AmenityExists(int hotelId) {
		String hql = "FROM Amenity as hot WHERE hot.amenityId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, hotelId)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
