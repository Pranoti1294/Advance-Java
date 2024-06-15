package com.example.SpringSecond;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        Vehicle vehicle = (Vehicle) applicationContext.getBean(Car.class);
        vehicle.run();
    }
}
