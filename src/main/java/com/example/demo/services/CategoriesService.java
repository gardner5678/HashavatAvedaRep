package com.example.demo.services;
import com.example.demo.model.Categories;
import com.example.demo.model.Founds;
import com.example.demo.repositories.CategoriesRepository;
import com.example.demo.repositories.FoundRepository;
import com.example.demo.repositories.I_CategoriesRepository;
//import com.example.demo.utility.T_Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoriesService {
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Transactional
	public List<Categories> getAllCategories() {
		return categoriesRepository.getAllCategories();
	}
	
	public Categories getFound(Long id) {
		return categoriesRepository.getCategory(id);
	}
//    I_CategoriesRepository categoriesRepository;
////    T_Transaction transaction;
//    public C_CategoriesService(I_CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
////        transaction = new T_Transaction();
//    	Categories c =  Categories.builder()
//    			.CategoryName("category1")
//    			.build();
//    	save(c);
//    }
//
//    @Override
//    public List<Categories> getCategoriess() {
//        List<Categories> categories = new ArrayList<>();
//        categoriesRepository.findAll().forEach(categories::add);
//        return categories;
//    }
//
//    @Override
//    public Categories getCategoriesById(Long id) {
//        return categoriesRepository.findById(id).get();
//    }
//
//    @Override
//    public Categories insert(Categories categories) {
//        return categoriesRepository.save(categories);
//    }
//
//    @Override
//    public void updateCategories(Long id, Categories categories) {
//        Categories categoriesFromDb = categoriesRepository.findById(id).get();
//        System.out.println(categoriesFromDb.toString());
//        categoriesFromDb.setCategoryName(categories.getCategoryName());
//        categoriesRepository.save(categoriesFromDb);
//    }
//
//    @Override
//    public void deleteCategories(Long categoriesId) {
//        categoriesRepository.deleteById(categoriesId);
//    }
//
//    @Override
//    @Transactional
//	public Categories save(Categories entity) {
////    	transaction.begin();
//    	categoriesRepository.save(entity);
////    	transaction.commit();
//		return entity;
//	}
}
