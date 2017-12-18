package com.qurishimi.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Car {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int car_id;
	String name;
	String photo;
	String speed;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	User user;
	public int getId() {
		return car_id;
	}
	public void setId(int car_id) {
		this.car_id = car_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
	
	public Car() {
		super();
	}
	@Override
	public String toString() {
		return "Cars [id=" + car_id + ", name=" + name + ", photo=" + photo + ", speed=" + speed + "]";
	}
	
	
	
}