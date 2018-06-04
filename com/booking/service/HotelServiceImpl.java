package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.HotelDAO;
import com.booking.entity.Hotel;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDAO hotelDAO;
	@Override
	public Hotel getHotelById(int hotelId) {
		Hotel obj = hotelDAO.getHotelById(hotelId);
		return obj;
	}	
	@Override
	public List<Hotel> getAllHotels(){
		return hotelDAO.getAllHotels();
	}
	@Override
	public synchronized boolean addHotel(Hotel hotel){
       if (hotelDAO.HotelExists(hotel.getHotelName())) {
    	   return false;
       } else {
    	   hotelDAO.addHotel(hotel);
    	   return true;
       }
	}
	@Override
	public void updateHotel(Hotel hotel) {
		hotelDAO.updateHotel(hotel);
	}
	@Override
	public void deleteHotel(int hotelId) {
		hotelDAO.deleteHotel(hotelId);
	}
}