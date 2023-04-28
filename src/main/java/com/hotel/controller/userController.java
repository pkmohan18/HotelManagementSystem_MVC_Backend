package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dao.hotelUserDao;
import com.hotel.dto.hotelUser;

@RestController
@RequestMapping("user")
@CrossOrigin
public class userController {
	
	@Autowired
	hotelUserDao dao;
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody hotelUser user) {
		dao.save(user);
		return new ResponseEntity<>("user Saved",HttpStatus.OK);
	}
	
	@GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<hotelUser>> getUSers() {
		List<hotelUser> list = dao.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteUser(@RequestParam int id){
		dao.delete(id);
		return new ResponseEntity<>("User deleted successfully!...",HttpStatus.OK);
	}
	
	@GetMapping(value = "getByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<hotelUser> getUSersByEmail(@RequestParam String email) {
		hotelUser user = dao.getByEmail(email);
		if(user!=null)
			return new ResponseEntity<>(user,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
}
