package com.example.springthird;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class SnapDragon implements Processor {

	@Override
	public void process() {
		System.out.println("SnapDragon doging its job..");
		
	}

}
