package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Colors;
import com.example.demo.entities.Materials;
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
	public Optional<Materials> getMaterial(Long id) {
		return materialRepository.getMaterial(id);
	}
}
