package com.qurishimi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String age;
	

}
