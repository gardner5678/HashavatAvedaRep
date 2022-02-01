package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Colors;
import com.example.demo.model.Materials;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class MaterialRepository {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<Materials> getAllMaterials() {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
//		Query<Founds> q = session.createSQLQuery("select * from "+Founds+"").addEntity(Founds.class).list();
		List<Materials> list = session.createSQLQuery("SELECT * FROM Materials").addEntity(Colors.class).list();
		return list;
	}
	public Materials getMaterial(Long id) {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session.find(Materials.class, id);
	}
}
