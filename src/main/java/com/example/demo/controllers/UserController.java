package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
import com.example.demo.entities.Users;
import com.example.demo.services.FoundService;
import com.example.demo.services.LostService;
import com.example.demo.services.UserService;
import com.example.demo.utility.UserLogic;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final FoundService foundService;
    final LostService lostService;
    final UserService userService;
	UserLogic userLogic;

	public UserController(FoundService foundService, LostService lostService, UserService userService) {
		this.foundService = foundService;
		this.lostService = lostService;
		this.userService = userService;
		this.userLogic = new UserLogic(userService, lostService, foundService);
	}
	@GetMapping(value = "/getUserLosts")
    public List<Losts> getUserLosts(String userId){
        return userLogic.getUserLosts(Long.parseLong(userId));
    }
	@GetMapping(value = "/getUserFounds/{userId}")
    public List<Founds> getUserFounds(@PathVariable("userId") Long userId){
        return userLogic.getUserFounds(userId);
    }
    @GetMapping({"/{mail}/{password}"})
    public Users get(@PathVariable("mail") String userMail, @PathVariable("password") String userPassword){
        return userLogic.signIn(userMail, userPassword);
    }
    @PostMapping({"/{user}"})
    public Long post(@RequestBody Users u){
        return userLogic.signUp(u);
    }
    @PostMapping("/uploadLogo")
    public String uploadLogo()
    {
    	//TODO לברר
//        System.Web.HttpRequest httpRequest = HttpContext.Current.Request;
//        System.Web.HttpPostedFile postedFile = httpRequest.Files["Image"];
//        if (postedFile != null)
//        {
//            String filePath = HttpContext.Current.Server.MapPath("~/Images/" + postedFile.FileName);
//            postedFile.SaveAs(filePath);
//            return postedFile.FileName;
//        }
        return null;

    }
}