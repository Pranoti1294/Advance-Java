package com.example.SpringSecond;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private int capacity;
	private int torque;
	private int power;
	
	public Engine() {
		capacity = 1200;
		power = 100;
		torque =150;
	}

	public Engine(int capacity, int torque, int power) {
		super();
		this.capacity = capacity;
		this.torque = torque;
		this.power = power;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Engine [capacity=" + capacity + "CC, torque=" + torque + "BHP, power=" + power + "NM]";
	}
	
	
}
