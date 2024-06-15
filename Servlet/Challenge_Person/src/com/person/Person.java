package com.person;

import java.sql.Date;

public class Person {

	private int id;
	private String name;
	private Date dobDate;
	
	public Person() {}
	
	public Person(int id, String name, Date dobDate) {
		super();
		this.id = id;
		this.name = name;
		this.dobDate = dobDate;
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
	public Date getDobDate() {
		return dobDate;
	}
	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dobDate=" + dobDate + "]";
	}
	
}
