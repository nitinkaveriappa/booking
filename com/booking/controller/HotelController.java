package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.booking.entity.Hotel;
import com.booking.service.HotelService;

@Controller
@RequestMapping("booking")
public class HotelController {
	@Autowired
	private HotelService HotelService;
	@GetMapping("hotel/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Integer id) {
		Hotel hotel = HotelService.getHotelById(id);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	@GetMapping("hotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> list = HotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(list, HttpStatus.OK);
	}
	@PostMapping("hotel")
	public ResponseEntity<Void> addHotel(@RequestBody Hotel hotel, UriComponentsBuilder builder) {
        boolean flag = HotelService.addHotel(hotel);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/hotel/{id}").buildAndExpand(hotel.getHotelId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("hotel")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		HotelService.updateHotel(hotel);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	@DeleteMapping("hotel/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable("id") Integer id) {
		HotelService.deleteHotel(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 