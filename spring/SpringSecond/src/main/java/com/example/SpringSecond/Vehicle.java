package com.example.SpringSecond;

import org.springframework.stereotype.Component;

@Component
public interface Vehicle {
	
	
	public default void run() {
		 System.out.println("its vehicle......");
	 }
}
