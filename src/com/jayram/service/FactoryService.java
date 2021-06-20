package com.jayram.service;

import com.jayram.model.Circle;
import com.jayram.model.Triangle;

public class FactoryService { //Creating custom Factory service
	
	public Object getBean(String beanType){
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		return null;
	}
}
