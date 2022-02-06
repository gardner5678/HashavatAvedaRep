package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Founds;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional
public class FoundRepository {
	@Autowired
	I_FoundRepository foundRepository;
	@Transactional
	public List<Founds> getAllFounds() {
		List<Founds> list = foundRepository.findAll();//session.createSQLQuery("SELECT * FROM Founds").addEntity(Founds.class).list();
		return list;
	}
	public Optional<Founds> getFounds(Long id) {
		return foundRepository.findById(id);//.find(Founds.class, id);
	}
	@Transactional
	public void saveFound(Founds found) {
		foundRepository.save(found);
	}
	@Transactional
	public void deleteFound(Founds found) {
		foundRepository.delete(found);
	}
	public List<Founds> getFoundsByUserId(Long id){
		return foundRepository.findLostsByUserIdParam(id);
	}
}