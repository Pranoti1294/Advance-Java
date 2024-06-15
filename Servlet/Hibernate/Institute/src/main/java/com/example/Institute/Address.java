package com.example.Institute;

public class Address {
	private int id;
	private String houseno;
	private String street;
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(int id, String houseno, String street, String city) {
		super();
		this.id = id;
		this.houseno = houseno;
		this.street = street;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseno=" + houseno + ", street=" + street + ", city=" + city + "]";
	}
	
	
	
}
