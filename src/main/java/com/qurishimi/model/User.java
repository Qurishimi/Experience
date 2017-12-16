package com.qurishimi.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
     
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
   
    @Column(name= "user_id")
	int id;
	
    @NotEmpty(message="Podane pole nie może być puste. Wprowadz wartość")
    @Size(min= 3, max= 10 , message="Imie nie może być krótsze niż 3 litery i dłuższe niż 10")
	String name;
    @NotEmpty(message="Podane pole nie może być puste. Wprowadz wartość")
    @Email(message="Podany format email jest niepoprawidłowy")
    String email;
    @NotEmpty(message="Podane pole nie może być puste. Wprowadz wartość")
	String password;
	boolean active;
    String likeToEat;
    
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns= @JoinColumn(name= "user_id") , inverseJoinColumns= @JoinColumn(name= "id") ) 
    Set<Role> role;
	
   @OneToOne(cascade= CascadeType.ALL)
   @JoinColumn(name="id" )
    UserDetails userDetails;
	
    
    
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public User() {};
	
	public User(String name, String email, String password, boolean active, String likeToEat) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.likeToEat = likeToEat;
	}
	public String getLikeToEat() {
		return likeToEat;
	}
	public void setLikeToEat(String likeToEat) {
		this.likeToEat = likeToEat;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", active=" + active + ", likeToEat="
				+ likeToEat + "]";
	}
	
	
	
}
