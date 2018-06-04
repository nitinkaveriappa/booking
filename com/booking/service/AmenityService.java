package com.booking.service;

import java.util.List;

import com.booking.entity.Amenity;

public interface AmenityService {

	Amenity getAmenityById(int amenityId);

	List<Amenity> getAllAmenitys();

	boolean addAmenity(Amenity amenity);

	void updateAmenity(Amenity amenity);

}
