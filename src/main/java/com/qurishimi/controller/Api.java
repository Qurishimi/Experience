package com.qurishimi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qurishimi.dao.UserDao;
import com.qurishimi.model.User;
import com.qurishimi.services.UserService;

@Controller
@RequestMapping("api")
public class Api {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="user/{id}", method= RequestMethod.GET )
	public @ResponseBody User user(@PathVariable int id) {
		
		return userDao.findOne(id);
				
	}
	
	
	@RequestMapping("users")
	public @ResponseBody List<User> user() {
		
		List<User> users = userDao.findAll();
		
		return  users;
				
	}
	
	
	
	
}
