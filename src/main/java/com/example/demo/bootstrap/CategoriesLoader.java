//package com.example.demo.bootstrap;
//
//import com.example.demo.model.Categories;
//import com.example.demo.repositories.I_CategoriesRepository;
//import com.example.demo.services.C_CategoriesService;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CategoriesLoader implements CommandLineRunner {
//    public final I_CategoriesRepository categoriesRepository;
//
//    public CategoriesLoader(I_CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
//        
//        C_CategoriesService cs  = new C_CategoriesService(categoriesRepository);
//    	Categories c =  Categories.builder()
//    			.CategoryName("category1")
//    			.build();
//    	cs.save(c);
//    }
//    
//    @Override
//    public void run(String... args) throws Exception {
//    	loadCategories();
//    }
//    private void loadCategories() {
//    }
//}
//
