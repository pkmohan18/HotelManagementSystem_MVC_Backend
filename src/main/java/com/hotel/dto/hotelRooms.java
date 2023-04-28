package com.hotel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class hotelRooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int roomNo;
	private String roomType;
	private int capacity;
	private int price;
	private Boolean isAvailable;
	
	public hotelRooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hotelRooms(int roomNo, String roomType, int capacity) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "hotelRooms [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", capacity=" + capacity
				+ ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}

}
