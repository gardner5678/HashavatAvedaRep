package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Colors;
import com.example.demo.entities.Founds;
import com.example.demo.entities.Items;
import com.example.demo.entities.Losts;
import com.example.demo.entities.Materials;
import com.example.demo.entities.Users;
import com.example.demo.entities.transportation.Agency;
import com.example.demo.entities.transportation.Route;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.ColorsService;
import com.example.demo.services.FoundService;
import com.example.demo.services.ItemService;
import com.example.demo.services.LostService;
import com.example.demo.services.MaterialService;
import com.example.demo.services.UserService;
import com.example.demo.utility.DataLogic;
import com.example.demo.utility.EmailSending;
import com.example.demo.utility.PublicTranspotation;
import com.example.demo.utility.SearchLogic;
import com.example.demo.utility.UserLogic;

@RestController
@RequestMapping("/api/data")
public class DataController {
	final CategoriesService categoriesService;
	final ColorsService colorsService;
    final FoundService foundService;
    final ItemService itemService;
    final LostService lostService;
    final MaterialService materialService;
    final UserService userService;
	UserLogic userLogic;
	DataLogic dataLogic;
	SearchLogic searchLogic;

	public DataController(
			CategoriesService categoriesService,
			ColorsService colorsService,
			FoundService foundService,
			ItemService itemService,
			LostService lostService,
			MaterialService materialService,
			UserService userService) {
		this.categoriesService = categoriesService;
		this.colorsService = colorsService;
		this.foundService = foundService;
		this.itemService = itemService;
		this.lostService = lostService;
		this.materialService = materialService;
		this.userService = userService;
		this.userLogic = new UserLogic(userService, lostService, foundService);
		dataLogic = new DataLogic(foundService, lostService, userService, categoriesService, itemService, materialService, colorsService);
		searchLogic = new SearchLogic(foundService, lostService);
		PublicTranspotation pt = new PublicTranspotation();
	}
	@GetMapping("")
    public String[] Get(){
        return new String[] { "value1", "value2" };
    }
	@GetMapping(value = "/getCategories")
    public List<Categories> getCategories(){
        return dataLogic.getCategories();
    }
	@GetMapping(value = "/getCompanies")
    public List<Users> getCompanies(){
        return dataLogic.getCompanies();
    }
    @GetMapping("/getAgencies")
    public List<Agency> getAgencies(){
        return PublicTranspotation.getAgencies();
    }
    @GetMapping("/getRoutes")
    public List<Route> getRoutes(){
    	return PublicTranspotation.getRoutes();
    }
    @GetMapping("/getItems")
    public List<Items> getItems()
    {
        return dataLogic.getItems();
    }
    @GetMapping("/getMaterial")
    public List<Materials> getMaterial()
    {
        return dataLogic.getMaterials();
    }
    @GetMapping("/getColors")
    public List<Colors> getColors()
    {
        return dataLogic.getColors();
    }
    @PostMapping("/saveFound/{found}")
    public List<Losts> SaveFound(@RequestBody Founds found){
        dataLogic.saveOrUpdateFound(found);
        List<Losts> losts = searchLogic.searchInLostsWithManyParams(found);
        return losts;
    }
    @PostMapping("/searchFound/{found}")
    public List<Losts> searchFound(@RequestBody Founds found){
        return searchLogic.searchInLostsWithManyParams(found);
    }
    @PostMapping("/updateFound/{fouund}")
    public boolean updateFound(@RequestBody Founds found){
        try {
            dataLogic.saveOrUpdateFound(found);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PostMapping("/deleteFound/{found}")
    public boolean deleteFound(@RequestBody Founds found){
    	try{
    		dataLogic.removeFound(found);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    @PostMapping("/updateFoundStatus/{id}")
    public boolean updateFoundStatus(@PathVariable Long id){
        try {
            dataLogic.updateFoundStatus(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @PostMapping("/saveLost/{lost}")
    public List<Founds> saveLost(@RequestBody Losts lost){
        dataLogic.saveOrUpdateLost(lost);
        List<Founds> founds= searchLogic.searchInFoundsWithManyParams(lost);
        return founds;
    }
    @PostMapping("/searchLost/{lost}")
    public List<Founds> searchLost(@RequestBody Losts lost){
        return searchLogic.searchInFoundsWithManyParams(lost);
    }
    @PostMapping("/updateLost/{lost}")
    public boolean updateLost(@RequestBody Losts lost){
        try{
            dataLogic.saveOrUpdateLost(lost);
            return true;

        }catch (Exception e){
            return false;
        }
    }
    @PostMapping("/deleteLost/")
    public boolean deleteLost(@RequestBody Losts lost){
        try{
            dataLogic.removeLost(lost);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @PostMapping("/updateLostStatus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean updateLostStatus(@PathVariable(value = "id") Long id){
        try {
            dataLogic.updateLostStatus(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @GetMapping("/mail/{text}/{id}")
    public boolean mail(@PathVariable String text,@PathVariable Long id){
        try{
        	String email = userService.getUser(id).get().getUserMail();
                EmailSending.sendToUser(email, text);
                return true;
        } catch(Exception e) {
            return false;
        }
    }
}