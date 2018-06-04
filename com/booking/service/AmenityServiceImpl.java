package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.AmenityDAO;
import com.booking.entity.Amenity;

@Service
public class AmenityServiceImpl implements AmenityService {
	@Autowired
	private AmenityDAO amenityDAO;
	@Override
	public Amenity getAmenityById(int amenityId) {
		Amenity obj = amenityDAO.getAmenityById(amenityId);
		return obj;
	}	
	@Override
	public List<Amenity> getAllAmenitys(){
		return amenityDAO.getAllAmenitys();
	}
	@Override
	public synchronized boolean addAmenity(Amenity amenity){
       if (amenityDAO.AmenityExists(amenity.getAmenityId())) {
    	   return false;
       } else {
    	   amenityDAO.addAmenity(amenity);
    	   return true;
       }
	}
	@Override
	public void updateAmenity(Amenity amenity) {
		amenityDAO.updateAmenity(amenity);
	}
}