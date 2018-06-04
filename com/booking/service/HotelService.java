package com.booking.service;

import java.util.List;

import com.booking.entity.Hotel;

public interface HotelService {

	Hotel getHotelById(int hotelId);

	List<Hotel> getAllHotels();

	boolean addHotel(Hotel hotel);

	void updateHotel(Hotel hotel);

	void deleteHotel(int hotelId);

}
