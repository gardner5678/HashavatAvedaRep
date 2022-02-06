package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Colors;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class ColorRepository {

	@Autowired
	I_ColorsRepository colorsRepository;
	@Transactional
	public List<Colors> getAllColors() {
		return colorsRepository.findAll();
	}
	public Optional<Colors> getColor(Long id) {
		return colorsRepository.findById(id);
	}
}
