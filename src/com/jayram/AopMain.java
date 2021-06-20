package com.jayram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jayram.service.FactoryService;
import com.jayram.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		shapeService.getCircle();

		FactoryService factoryService = new FactoryService(); //Getting custom Factory instance
		ShapeService shapeSrvice = (ShapeService) factoryService.getBean("shapeService");
		shapeSrvice.getTriangle();
	}

}
