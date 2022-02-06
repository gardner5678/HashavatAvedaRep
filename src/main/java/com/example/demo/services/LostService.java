package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Losts;
//import com.example.demo.utility.T_Transaction;
import com.example.demo.repositories.LostRepository;

@Service
public class LostService {
	@Autowired
	LostRepository lostRepository;
	
	public List<Losts> getAllLosts() {
		return lostRepository.getAllLosts();
	}
	public Optional<Losts> getLost(Long id) {
		return lostRepository.getLost(id);
	}
	public void saveOrUpdateLost(Losts lost) {
		lostRepository.saveLost(lost);
	}
	public void deleteLost(Losts lost) {
		lostRepository.deleteLost(lost);
	}
	public List<Losts> getLostsByUserId(Long id){
		return lostRepository.getLostsByUserId(id);
	}
}
