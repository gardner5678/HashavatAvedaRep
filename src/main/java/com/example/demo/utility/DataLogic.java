package com.example.demo.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Colors;
import com.example.demo.entities.Founds;
import com.example.demo.entities.Items;
import com.example.demo.entities.Losts;
import com.example.demo.entities.Materials;
import com.example.demo.entities.Users;
import com.example.demo.repositories.FoundRepository;
import com.example.demo.repositories.I_FoundRepository;
import com.example.demo.repositories.I_LostRepository;
import com.example.demo.repositories.LostRepository;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.ColorsService;
import com.example.demo.services.FoundService;
import com.example.demo.services.ItemService;
import com.example.demo.services.LostService;
import com.example.demo.services.MaterialService;
import com.example.demo.services.UserService;

public class DataLogic {
	public final FoundService foundService;
	public final LostService lostService;
	public final UserService userService;
	public final CategoriesService categoriesService;
	public final ItemService itemService;
	public final MaterialService materialService;	
	public final ColorsService colorsService;

	public DataLogic(
			FoundService foundService,
			LostService lostService, 
			UserService userService, 
			CategoriesService categoriesService,
			ItemService itemService,
			MaterialService materialService,
			ColorsService colorsService) {
		this.foundService = foundService;
		this.lostService = lostService;
		this.userService = userService;
		this.categoriesService = categoriesService;
		this.itemService = itemService;
		this.materialService = materialService;
		this.colorsService = colorsService;
	}
    public List<Users> getCompanies(){
        return userService.getAllUsers();
    }
    public List<Categories> getCategories(){
        return categoriesService.getAllCategories();
    }
    public List<Items> getItems(){
        return itemService.getAllItems();
    }
    public List<Materials> getMaterials(){
        return materialService.getAMaterials();
    }
    public List<Colors> getColors(){
        return colorsService.getAllColors();
    }
    public void saveOrUpdateLost(Losts lost){
    	lostService.saveOrUpdateLost(lost);
    }
    public void removeLost(Losts lost){
    	lostService.deleteLost(lost);
    }
    public void saveOrUpdateFound(Founds found){
    	foundService.saveOrUpdateFound(found);
    }
    public void removeFound(Founds found){
    	foundService.deleteFound(found);
    }
    public void updateLostStatus(Long id){
    	Losts lost = lostService.getLost(id).get();
    	lost.setLostStatus(true);
    	lostService.saveOrUpdateLost(lost);
    }
    public void updateFoundStatus(Long id){
    	Founds found = foundService.getFound(id).get();
    	found.setFoundStatus(true);
    	foundService.saveOrUpdateFound(found);
    }
}
