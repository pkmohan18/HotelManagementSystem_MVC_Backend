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

import com.hotel.dao.bookedRoomsDao;
import com.hotel.dto.bookedRooms;
import com.hotel.dto.hotelRooms;

@Controller
@RequestMapping("bookedRoom")
@CrossOrigin
public class bookedRoomController {
	
	@Autowired
	bookedRoomsDao dao;
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveRoom(@RequestBody bookedRooms room) {
		dao.save(room);
		return new ResponseEntity<>("Room Saved",HttpStatus.OK);
	}
	
	@PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateRoom(@RequestBody bookedRooms room) {
		dao.update(room);
		return new ResponseEntity<>("Room updated",HttpStatus.OK);
	}
	
	@GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<bookedRooms>> getRooms() {
		List<bookedRooms> list = dao.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteRoom(@RequestParam int id){
		dao.delete(id);
		return new ResponseEntity<>("Room deleted successfully!...",HttpStatus.OK);
	}
	
	@GetMapping(value = "getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<bookedRooms> getRoomById(@RequestParam int id) {
		bookedRooms room = dao.getById(id);
		if(room!=null)
			return new ResponseEntity<>(room,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "getByNo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<bookedRooms> getRoomByRoomNo(@RequestParam int num) {
		bookedRooms room = dao.getByNo(num);
		if(room!=null)
			return new ResponseEntity<>(room,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
