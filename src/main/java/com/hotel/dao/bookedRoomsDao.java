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
public class bookedRoomsDao {
	SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(hotelUser.class).addAnnotatedClass(hotelRooms.class).addAnnotatedClass(bookedRooms.class)
			.buildSessionFactory();
	
	
	public void save(bookedRooms room) {
		Session session = factory.openSession();
		session.save(room);
		session.close();
	}

	public List<bookedRooms> getAll() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from bookedRooms");
		List<bookedRooms> list = query.getResultList();
		transaction.commit();
		session.close();
		return list;
	}


	public void delete(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		bookedRooms room = session.get(bookedRooms.class, id);
		session.delete(room);
		transaction.commit();
		session.close();
	}

	public bookedRooms getByNo(int roomNo) {
		Session session = factory.openSession();
		Query query = session.createQuery("from bookedRooms where roomNo=:roomNo");
		query.setParameter("roomNo", roomNo);
		bookedRooms room = (bookedRooms) query.getSingleResult();
		session.close();
		return room;
	}

	public bookedRooms getById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		bookedRooms room = session.get(bookedRooms.class, id);
		transaction.commit();
		session.close();
		return room;
	}

	public void update(bookedRooms room) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(room);
		transaction.commit();
		session.close();
		
	}
}
