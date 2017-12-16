package com.qurishimi.model;

public class Fruit {

	String name;
	String imageURL;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Fruit(String name, String imageURL) {
		super();
		this.name = name;
		this.imageURL = imageURL;
	}
	
	
	
}
