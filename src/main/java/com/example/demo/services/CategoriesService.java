package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Categories;
import com.example.demo.repositories.CategoriesRepository;

@Service
@Transactional
public class CategoriesService {
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Transactional
	public List<Categories> getAllCategories() {
		return categoriesRepository.getAllCategories();
	}
	
	public Optional<Categories> getFound(Long id) {
		return categoriesRepository.getCategory(id);
	}
}
