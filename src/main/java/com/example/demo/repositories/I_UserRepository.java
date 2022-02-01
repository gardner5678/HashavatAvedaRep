package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface I_UserRepository extends JpaRepository<Users, Long> {
	@Query("SELECT u FROM Users u WHERE u.userMail = :email")
	Users findUserByEmailParam(@Param("email") String email);
}
