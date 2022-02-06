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
import com.example.demo.entities.Materials;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class MaterialRepository {

	@Autowired
	I_MaterialRepository materialRepository;
	@Transactional
	public List<Materials> getAllMaterials() {
		return materialRepository.findAll();
	}
	public Optional<Materials> getMaterial(Long id) {
		return materialRepository.findById(id);
	}
}
