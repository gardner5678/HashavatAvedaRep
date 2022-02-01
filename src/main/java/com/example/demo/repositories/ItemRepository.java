package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Items;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class ItemRepository {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<Items> getAllItems() {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
//		Query<Founds> q = session.createSQLQuery("select * from "+Founds+"").addEntity(Founds.class).list();
		List<Items> list = session.createSQLQuery("SELECT * FROM Founds").addEntity(Items.class).list();
		return list;
	}
	public Items getItems(Long id) {
		Session session = null;
		try {
			session= sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session.find(Items.class, id);
	}
//	T_Transaction transaction = new T_Transaction();
//    SessionFactory factory = Hibernate.getSessionFactory();
//    Session session = factory.openSession();
//	@Override
//	public <S extends Categories> S save(S entity) {
////		transaction.begin();
//		iCarCategoriesRepository.save(entity);
////		transaction.commit();
//		return entity;
//	}
//
//	@Override
//	public <S extends Categories> Iterable<S> saveAll(Iterable<S> entities) {
//	    for(S iter : entities) {
//	    	iCarCategoriesRepository.save(iter);
//	    }
//		return entities;
//	}
//
//	@Override
//	public Optional<Categories> findById(Long id) {
//		Categories category = iCarCategoriesRepository.findById(id).get();
//		return Optional.ofNullable(category);
//	}
//
//	@Override
//	public boolean existsById(Long id) {
//	    if(iCarCategoriesRepository.findById(id).equals(null)) {
//	    	return false;
//	    }
//	    return true;
//	}
//
//	@Override
//	public Iterable<Categories> findAll() {
//		return iCarCategoriesRepository.findAll();
//	}
//
//	@Override
//	public Iterable<Categories> findAllById(Iterable<BigDecimal> ids) {
//		return iCarCategoriesRepository.findAllById(ids);
//	}
//
//	@Override
//	public Long count() {
//		return iCarCategoriesRepository.count();
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		iCarCategoriesRepository.deleteById(id);
//	}
//
//	@Override
//	public void delete(Categories entity) {
//		iCarCategoriesRepository.delete(entity);
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends BigDecimal> ids) {
//		Long id = null;
//		while((id = ids.iterator().next()) != null) {
//			iCarCategoriesRepository.deleteById(id);
//		}
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Categories> entities) {
//		Categories entity = null;
//		while((entity = entities.iterator().next())!=null) {
//			iCarCategoriesRepository.delete(entity);
//		}
//	}
//
//	@Override
//	public void deleteAll() {
//		iCarCategoriesRepository.deleteAll();
//	}
//
}
