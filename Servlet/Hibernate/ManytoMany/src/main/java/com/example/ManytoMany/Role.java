package com.example.ManytoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "listOfRoles",cascade = { CascadeType.ALL })
	
	private List<Actor> listOfActors = new ArrayList<Actor>();
	
	
	
	public List<Actor> getListOfActors() {
		return listOfActors;
	}
	public void setListOfActors(List<Actor> listOfActors) {
		this.listOfActors = listOfActors;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", listOfActors=" + listOfActors
				+ "]";
	}
	
	
}
