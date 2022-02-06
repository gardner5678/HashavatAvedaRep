package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
import com.example.demo.services.FoundService;
import com.example.demo.services.LostService;
import com.example.demo.utility.SearchLogic;

@RestController
@RequestMapping("/api/searches")
public class SearchesController {
    final FoundService foundService;
    final LostService lostService;
	SearchLogic searchLogic;

	public SearchesController(FoundService foundService, LostService lostService) {
		this.foundService = foundService;
		this.lostService = lostService;
		searchLogic = new SearchLogic(foundService, lostService);
	}
    @GetMapping(value = "/allFounds")
    public ResponseEntity<List<Founds>> getAllFounds() {
        List<Founds> founds = foundService.getAllFounds();
        return new ResponseEntity<>(founds, HttpStatus.OK);
    } 
    @GetMapping(value = "/allLosts")
    public ResponseEntity<List<Losts>> getAllLosts() {
        List<Losts> losts = lostService.getAllLosts();
        return new ResponseEntity<>(losts, HttpStatus.OK);
    }
    @GetMapping({"/searchInFounds/{categoryId}/{locationlat}/{locationlng}/{radius}"})
    public List<Founds> SearchInFounds(
    		@PathVariable("categoryId") Long categoryId,
    		@PathVariable("locationlat") Double locationlat,
    		@PathVariable("locationlng") Double locationlng,
    		@PathVariable("radius") Double radius)
    {
        return searchLogic.UniversalSearchInFounds(categoryId, locationlat, locationlng, radius);
    } 
    @GetMapping(value = "/searchInLosts/{categoryId}/{locationlat}/{locationlng}/{radius}")
    public List<Losts> SearchInLosts(
    		@PathVariable("categoryId") Long categoryId,
    		@PathVariable("locationlat") Double locationlat,
    		@PathVariable("locationlng") Double locationlng,
    		@PathVariable("radius") Double radius)
    {
        return searchLogic.UniversalSearchInLosts(categoryId, locationlat, locationlng, radius);
    }
}