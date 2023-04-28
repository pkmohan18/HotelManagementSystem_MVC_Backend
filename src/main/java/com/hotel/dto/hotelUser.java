package com.hotel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class hotelUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private Long phno;
	private String idType;
	private String idNo;
	@Column(unique = true)
	private String email;
	private String password;
	private String con_password;
	private Boolean isAdmin;
	private int noRooms;
	
	public hotelUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hotelUser(String fname, String lname, String dob, String gender, Long phno, String idType, String idNo,
			String email, String password, String con_password, Boolean isAdmin, int noRooms) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.phno = phno;
		this.idType = idType;
		this.idNo = idNo;
		this.email = email;
		this.password = password;
		this.con_password = con_password;
		this.isAdmin = isAdmin;
		this.noRooms = noRooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCon_password() {
		return con_password;
	}

	public void setCon_password(String con_password) {
		this.con_password = con_password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	@Override
	public String toString() {
		return "hotelUser [id=" + id + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", gender=" + gender
				+ ", phno=" + phno + ", idType=" + idType + ", idNo=" + idNo + ", email=" + email + ", password="
				+ password + ", con_password=" + con_password + ", isAdmin=" + isAdmin + ", noRooms=" + noRooms + "]";
	}
	
}
