package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FoundLoader implements CommandLineRunner {

	public FoundLoader(/* I_FoundRepository foundRepository, I_LostRepository lostRepository */) {
//        this.foundRepository = foundRepository;
//        this.lostRepository = lostRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
    	loadSearchesController();
    }
    private void loadSearchesController() {
//    	SearchesController sc = new SearchesController(foundRepository, lostRepository);
    }
}

