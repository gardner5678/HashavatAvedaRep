package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Losts;
import com.example.demo.model.Users;

@Repository
public interface I_LostRepository extends JpaRepository<Losts, Long> {
	@Query("SELECT l FROM Losts l WHERE l.userId = :id")
	List<Losts> findLostsByUserIdParam(@Param("id") Long id);
	
}
