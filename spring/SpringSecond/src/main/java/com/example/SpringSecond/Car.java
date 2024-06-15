package com.example.SpringSecond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	
	@Autowired
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}


	public void setEngine(Engine engine) {
		this.engine = engine;
	}


	public void run() {
		System.out.println("its cars");
		System.out.println("Engine.."+engine);
	}
}
