package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.booking.entity.Amenity;
import com.booking.service.AmenityService;

@Controller
@RequestMapping("booking")
public class AmenityController {
	@Autowired
	private AmenityService AmenityService;
	@GetMapping("amenity/{id}")
	public ResponseEntity<Amenity> getAmenityById(@PathVariable("id") Integer id) {
		Amenity amenity = AmenityService.getAmenityById(id);
		return new ResponseEntity<Amenity>(amenity, HttpStatus.OK);
	}
	@GetMapping("amenities")
	public ResponseEntity<List<Amenity>> getAllAmenitys() {
		List<Amenity> list = AmenityService.getAllAmenitys();
		return new ResponseEntity<List<Amenity>>(list, HttpStatus.OK);
	}
	@PostMapping("amenity")
	public ResponseEntity<Void> addAmenity(@RequestBody Amenity amenity, UriComponentsBuilder builder) {
        boolean flag = AmenityService.addAmenity(amenity);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/amenity/{id}").buildAndExpand(amenity.getAmenityId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("amenity")
	public ResponseEntity<Amenity> updateAmenity(@RequestBody Amenity amenity) {
		AmenityService.updateAmenity(amenity);
		return new ResponseEntity<Amenity>(amenity, HttpStatus.OK);
	}
} 