package com.example.demo.services;
import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
import com.example.demo.repositories.FoundRepository;
import com.example.demo.repositories.I_FoundRepository;
//import com.example.demo.utility.T_Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoundService {
	@Autowired
	FoundRepository foundRepository;
  protected final Log logger = LogFactory.getLog(getClass());
	public List<Founds> getAllFounds() {
      logger.debug("getDailySales with params start/end: ");
		return foundRepository.getAllFounds();
	}
	
	public Optional<Founds> getFound(Long id) {
		return foundRepository.getFounds(id);
	}
	public void saveOrUpdateFound(Founds found) {
		foundRepository.saveFound(found);
	}
	public void deleteFound(Founds found) {
		foundRepository.deleteFound(found);
	}
	public List<Founds> getFoundsByUserId(Long id){
		return foundRepository.getFoundsByUserId(id);
	}
}
