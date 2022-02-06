package com.example.demo.services;
import com.example.demo.entities.Founds;
import com.example.demo.entities.Items;
import com.example.demo.repositories.FoundRepository;
import com.example.demo.repositories.I_ItemRepository;
//import com.example.demo.utility.T_Transaction;
import com.example.demo.repositories.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.math.BigDecimal;

@Service
@Transactional
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	@Transactional
	public List<Items> getAllItems() {
		return itemRepository.getAllItems();
	}
	
	public Optional<Items> getFound(Long id) {
		return itemRepository.getItems(id);
	}}
