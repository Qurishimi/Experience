package com.qurishimi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qurishimi.model.Fruit;
import com.qurishimi.model.Role;
import com.qurishimi.model.User;
import com.qurishimi.model.UserDetails;
import com.qurishimi.services.UserService;


@Controller
public class Register {
	
	@Autowired
	UserService userService;

	// Adding object to the form in view register.html
	@ModelAttribute
	public void addUser(Model model) {
		User user = new User(null ,null, null, false, null);
        
		
		List<Fruit> lista = new ArrayList<Fruit>();
		lista.add(new Fruit("Jabłka", "black"));
		lista.add(new Fruit("Pomidory", "green"));
		lista.add(new Fruit("Banany", "white"));
		lista.add(new Fruit("Truskawki", "yellow"));
		lista.add(new Fruit("Melony", "jabka"));
		lista.add(new Fruit("Kokosy", "jabka"));

		model.addAttribute("user", user);
		model.addAttribute("lista", lista);
	}

	@RequestMapping(value = "register")
	public ModelAndView getRegisterForm() {

		return new ModelAndView("register");

	}

	@RequestMapping(value = "createUser")
	public String registerUser(@Valid User user,  BindingResult br, String passwordCheck, Model model) {

		System.out.println(user);
	

		if (br.hasErrors() || !user.getPassword().equals(passwordCheck) || userService.exist(user)) {
			
				if( !user.getPassword().equals(passwordCheck))
					model.addAttribute("passwordMessage", "Wartość hasła wprowadzonego ponownie różni się od pierwszego");
			
				if(userService.exist(user))
				model.addAttribute("message_email_exist", "Wprowadzony email istnieje");
		   
	        model.addAttribute("message_failed", "Użytkownik nie został dodany! Popraw formularz");
			return "register";
			
		}
	
	    Set<Role> roles = new HashSet<Role>();
	    roles.add(new Role(2, "USER"));
		user.setRole(roles);
		
		UserDetails userDetails = new UserDetails();
		
		
		
		userService.addUser(user);
	    System.out.println(user);
		
		
	    model.addAttribute("message", "Użytkownik został dodany pomyślnie jako:" + user);
	    
	    
		return "register";

	}

	
	
}
