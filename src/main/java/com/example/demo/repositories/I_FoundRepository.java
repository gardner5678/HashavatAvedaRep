package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Founds;

@Repository
public interface I_FoundRepository extends JpaRepository<Founds, Long>{
	@Query("SELECT f FROM Founds f WHERE f.userId = :id")
	List<Founds> findLostsByUserIdParam(@Param("id") Long id);
}
