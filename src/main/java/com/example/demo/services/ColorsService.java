package com.example.demo.services;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Colors;
import com.example.demo.repositories.ColorRepository;

@Service
@Transactional
public class ColorsService{
	@Autowired
	ColorRepository colorRepository;
	
	@Transactional
	public List<Colors> getAllColors() {
		return colorRepository.getAllColors();
	}
	@Transactional
	public Optional<Colors> getColor(Long id) {
		return colorRepository.getColor(id);
	}
}
