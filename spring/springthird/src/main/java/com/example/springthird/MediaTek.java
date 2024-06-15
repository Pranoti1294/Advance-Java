package com.example.springthird;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MediaTek implements Processor {

	@Override
	public void process() {
		System.out.println("mediatek its my class ok ok...");
		
	}

}
