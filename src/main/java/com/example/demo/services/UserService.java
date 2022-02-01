package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Users;
import com.example.demo.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public List<Users> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public Optional<Users> getUser(Long id) {
		return userRepository.getUser(id); 
	}
	
	public Users getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
	public Users saveUser(Users user) {
		return userRepository.saveUser(user);
	}
}
