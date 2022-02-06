package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class LostRepository {

	@Autowired
	I_LostRepository lostRepository;
	@Transactional
	public List<Losts> getAllLosts() {
		List<Losts> list = lostRepository.findAll();//session.createSQLQuery("SELECT * FROM Founds").addEntity(Founds.class).list();
		return list;
	}
	@Transactional
	public Optional<Losts> getLost(Long id) {
		return lostRepository.findById(id);
	}
	@Transactional
	public Losts saveLost(Losts lost) {
		return lostRepository.save(lost);
	}
	@Transactional
	public void deleteLost(Losts lost) {
	}
	public List<Losts> getLostsByUserId(Long id){
		return lostRepository.findLostsByUserIdParam(id);
	}
}
