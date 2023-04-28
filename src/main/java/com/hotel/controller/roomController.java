package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.dao.hotelRoomsDao;
import com.hotel.dto.hotelRooms;

@Controller
@RequestMapping("room")
@CrossOrigin
public class roomController {
	
	@Autowired
	hotelRoomsDao dao;
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveRoom(@RequestBody hotelRooms room) {
		dao.save(room);
		return new ResponseEntity<>("Room Saved",HttpStatus.OK);
	}
	
	@GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<hotelRooms>> getRooms() {
		List<hotelRooms> list = dao.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteRoom(@RequestParam int id){
		dao.delete(id);
		return new ResponseEntity<>("Room deleted successfully!...",HttpStatus.OK);
	}
	
	@GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<hotelRooms> getRoomById(@RequestParam int id) {
		hotelRooms room = dao.getById(id);
		if(room!=null)
			return new ResponseEntity<>(room,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "getByNo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<hotelRooms> getRoomByRoomNo(@RequestParam int num) {
		hotelRooms room = dao.getByNo(num);
		if(room!=null)
			return new ResponseEntity<>(room,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
}
