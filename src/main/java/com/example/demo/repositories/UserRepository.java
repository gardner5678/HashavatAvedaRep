package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Users;
//import com.example.demo.utility.T_Transaction;
@Repository
@Transactional(readOnly=false)
public class UserRepository {

	@Autowired
	I_UserRepository userRepository;
	@Transactional
	public List<Users> getAllUsers() {
		List<Users> list = userRepository.findAll();
		return list;
	}
	public Optional<Users> getUser(Long id) {
		return userRepository.findById(id);
	}
	public Users getUserByEmail(String email){
		return userRepository.findUserByEmailParam(email);
	}
	@Transactional
	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
}
