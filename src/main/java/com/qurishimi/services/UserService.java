package com.qurishimi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qurishimi.dao.UserDao;
import com.qurishimi.dao.UserDetailsDao;
import com.qurishimi.model.User;
import com.qurishimi.model.UserDetails;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDetailsDao userDetailsDao;
	
	public boolean addUser(User user){
		
		UserDetails userDetails = new UserDetails();
		
		userDetailsDao.save(userDetails);
		
		return userDao.save(user) != null;
		
	}
	
	public boolean exist(User user) {
		 List<User> list=  userDao.findByEmail(user.getEmail());
		
	if(list.size()== 0) return false;
	
	 
	 
	 return true;
	}
	
}
