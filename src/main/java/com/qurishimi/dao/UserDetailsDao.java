package com.qurishimi.dao;

import org.springframework.data.repository.CrudRepository;

import com.qurishimi.model.UserDetails;

public interface UserDetailsDao extends CrudRepository<UserDetails, Integer> {

}
