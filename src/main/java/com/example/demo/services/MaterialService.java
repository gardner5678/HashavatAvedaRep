package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Colors;
import com.example.demo.model.Materials;
import com.example.demo.repositories.ColorRepository;
import com.example.demo.repositories.MaterialRepository;
import java.math.BigDecimal;

@Service
@Transactional
public class MaterialService{
	@Autowired
	MaterialRepository materialRepository;
	
	@Transactional
	public List<Materials> getAMaterials() {
		return materialRepository.getAllMaterials();
	}
	@Transactional
	public Materials getMaterial(Long id) {
		return materialRepository.getMaterial(id);
	}
}
