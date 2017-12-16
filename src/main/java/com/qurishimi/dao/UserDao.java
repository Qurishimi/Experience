package com.qurishimi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qurishimi.model.User;
import java.lang.String;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {


	List<User> findByEmail(String email);
	
	
	
	
}
