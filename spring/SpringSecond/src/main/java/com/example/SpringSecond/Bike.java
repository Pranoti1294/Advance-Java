package com.example.SpringSecond;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
	 public void run() {
		System.out.println("its bike..");
	}
}
