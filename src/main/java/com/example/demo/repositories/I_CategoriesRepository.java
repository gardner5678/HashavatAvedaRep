package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Categories;

@Repository
public interface I_CategoriesRepository extends JpaRepository<Categories, Long> {}
