package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Colors;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class ColorRepository {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<Colors> getAllColors() {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
//		Query<Founds> q = session.createSQLQuery("select * from "+Founds+"").addEntity(Founds.class).list();
		List<Colors> list = session.createSQLQuery("SELECT * FROM Colors").addEntity(Colors.class).list();
		return list;
	}
	public Colors getColor(Long id) {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session.find(Colors.class, id);
	}
}
