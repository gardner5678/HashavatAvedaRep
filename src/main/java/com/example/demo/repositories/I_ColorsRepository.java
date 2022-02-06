package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Colors;

@Repository
public interface I_ColorsRepository extends JpaRepository<Colors, Long> {}
