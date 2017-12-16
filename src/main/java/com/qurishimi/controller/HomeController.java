package com.qurishimi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qurishimi.dao.UserDao;
import com.qurishimi.model.User;
import com.qurishimi.services.UserService;

@Controller
public class HomeController {

	@Autowired
	UserDao userDao;
	
	
	@ModelAttribute
	public void add(Model model) {
		model.addAttribute("user" , userDao.findByEmail("ab@ab"));
		
		
	}
	
	@RequestMapping("/")
	public String welcome(  Model model) {
		
		return "home";
	}
	
	
}
