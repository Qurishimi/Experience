package com.qurishimi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qurishimi.dao.CarDao;
import com.qurishimi.dao.RoleDao;
import com.qurishimi.dao.UserDao;
import com.qurishimi.dao.UserDetailsDao;
import com.qurishimi.model.Car;
import com.qurishimi.model.Role;
import com.qurishimi.model.User;
import com.qurishimi.model.UserDetails;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	CarDao carDao;
	
	
public boolean addCar(int id){
		
		
       User user = userDao.findOne(id);
	   
       Car car = new Car();
       car.setPhoto("a");
       car.setName("ferrari");
       car.setSpeed("220");
       car.setUser(user);
       carDao.save(car);
       
       user.setCar(new ArrayList<Car>(Arrays.asList(car)));
		
		return userDao.save(user) != null;
		
	}
	
	public boolean addUser(User user){
		
		UserDetails userDetails = new UserDetails();
       
		
		user.setRole(new HashSet<Role>(Arrays.asList( roleDao.findOne(2))));
		
		userDetailsDao.save(userDetails);
		user.setUserDetails(userDetails);
		
		return userDao.save(user) != null;
		
	}
	
	public boolean exist(User user) {
		 List<User> list=  userDao.findByEmail(user.getEmail());
		
	if(list.size()== 0) return false;
	
	 
	 
	 return true;
	}
	
}
