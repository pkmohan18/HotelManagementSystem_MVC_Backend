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
public class hotelUserDao {
	
	SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(hotelUser.class).addAnnotatedClass(hotelRooms.class).addAnnotatedClass(bookedRooms.class)
			.buildSessionFactory();
	
	
	public void save(hotelUser user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	public List<hotelUser> getAll() {
		Session session = factory.openSession();
		Query query = session.createQuery("from hotelUser");
		List<hotelUser> list = query.getResultList();
		session.close();
		return list;
	}

	public void delete(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		hotelUser user = session.get(hotelUser.class, id);
		session.delete(user);
		transaction.commit();
		session.close();
	}

	public hotelUser getByEmail(String email) {
		Session session = factory.openSession();
		Query query = session.createQuery("from hotelUser where email=:email");
		query.setParameter("email", email);
		hotelUser user = (hotelUser) query.getSingleResult();
		session.close();
		return user;
	}

}
