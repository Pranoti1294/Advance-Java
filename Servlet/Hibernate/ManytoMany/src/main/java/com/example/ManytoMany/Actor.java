package com.example.ManytoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.cfg.Configuration;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Role> listOfRoles = new ArrayList<>();
	
	
	
	public List<Role> getListOfRoles() {
		return listOfRoles;
	}
	public void setListOfRoles(List<Role> listOfRoles) {
		this.listOfRoles = listOfRoles;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", phone=" + phone + ", listOfRoles=" + listOfRoles + "]";
	}
	
	
	
}
