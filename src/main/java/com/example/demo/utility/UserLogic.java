package com.example.demo.utility;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Founds;
import com.example.demo.entities.Losts;
import com.example.demo.entities.Users;
import com.example.demo.services.FoundService;
import com.example.demo.services.LostService;
import com.example.demo.services.UserService;

public class UserLogic {
	public final UserService userService;
	public final LostService lostService;
	public final FoundService foundService;
	
	public UserLogic(UserService userService, LostService lostService, FoundService foundService) {
		this.userService = userService;
		this.lostService = lostService;
		this.foundService = foundService;
	}
	
    EmailSending emailSending = new EmailSending();
    public Users signIn(String userMail, String userPassword)
    {
        Users user = userService.getUserByEmail(userMail);
        if (user != null && user.getUserPassword().equals(userPassword)) {
        	return user;
        }
        return null;
    }
    public Long signUp(Users u)
    {
//        Users user = userService.getUserByEmail(u.getUserMail());
        if (userService.getUserByEmail(u.getUserMail()) == null)
        {
        	userService.saveUser(u);
            try
            {
                emailSending.sendNewUser(u.getUserMail());
            }
            catch (Exception e) {
			}
            return userService.getUserByEmail(u.getUserMail()).getUserId();
        }
        return 0L;
    }
    public List<Losts> getUserLosts(Long id)
    {
        return lostService.getLostsByUserId(id);
    }
    public List<Founds> getUserFounds(Long id){
    	return foundService.getFoundsByUserId(id);
    }
}
