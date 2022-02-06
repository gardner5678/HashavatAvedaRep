package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//
//import org.arpit.java2blog.dao.List;
//import org.arpit.java2blog.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Categories;
//import com.example.demo.utility.T_Transaction;
@Repository
public class CategoriesRepository {
	@Autowired
	I_CategoriesRepository categoriesRepository;
	@Transactional
	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}
	public Optional<Categories> getCategory(Long id) {
		return categoriesRepository.findById(id);
	}
}
