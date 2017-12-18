package com.qurishimi.dao;

import org.springframework.data.repository.CrudRepository;

import com.qurishimi.model.Car;

public interface CarDao extends CrudRepository<Car, Integer> {

	
	
}
