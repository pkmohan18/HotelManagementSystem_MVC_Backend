package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hotel.dto.bookedRooms;
import com.hotel.dto.hotelRooms;
import com.hotel.dto.hotelUser;

@Repository
public class hotelRoomsDao {
	
	SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(hotelUser.class).addAnnotatedClass(hotelRooms.class).addAnnotatedClass(bookedRooms.class)
			.buildSessionFactory();
	
	
	public void save(hotelRooms room) {
		Session session = factory.openSession();
		session.save(room);
		session.close();
	}

	public List<hotelRooms> getAll() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from hotelRooms");
		List<hotelRooms> list = query.getResultList();
		transaction.commit();
		session.close();
		return list;
	}


	public void delete(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		hotelRooms room = session.get(hotelRooms.class, id);
		session.delete(room);
		transaction.commit();
		session.close();
	}

	public hotelRooms getByNo(int roomNo) {
		Session session = factory.openSession();
		Query query = session.createQuery("from hotelRooms where roomNo=:roomNo");
		query.setParameter("roomNo", roomNo);
		hotelRooms room = (hotelRooms) query.getSingleResult();
		session.close();
		return room;
	}

	public hotelRooms getById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		hotelRooms room = session.get(hotelRooms.class, id);
		transaction.commit();
		session.close();
		return room;
	}
}
