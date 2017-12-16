package com.qurishimi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qurishimi.dao.UserDao;
import com.qurishimi.model.User;

@Controller
public class TableController {

	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="tablica")
	public String getTablica(String id) {
		
	
		
		return "UserDetails";
	}
	
	
	@RequestMapping(value="getUserById", method= RequestMethod.POST )
	public String getUserById(String id, Model model) {
		
		User user =  userDao.findOne(Integer.parseInt(id));
		
		
		
		System.out.println(user.getUserDetails().getAge());
		model.addAttribute("user", user);
		
		
		return "UserDetails";
	}
	
	
	
	
}
