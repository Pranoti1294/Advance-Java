package com.example.springthird;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungPhone {
	
	@Autowired
	@Qualifier("snapDragon")
	Processor processor;
	
	public void specs() {
		System.out.println("Ram 8gb achha hai phone lelo");
		processor.process();
	}
}
