package com.booking.dao;

import java.util.List;

import com.booking.entity.Amenity;

public interface AmenityDAO {

	Amenity getAmenityById(int amenityId);

	List<Amenity> getAllAmenitys();

	void addAmenity(Amenity amenity);

	void updateAmenity(Amenity amenity);

	boolean AmenityExists(int hotelId);

}
