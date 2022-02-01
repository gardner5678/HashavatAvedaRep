package com.example.demo.services;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Colors;
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
	public Colors getColor(Long id) {
		return colorRepository.getColor(id);
	}
}
