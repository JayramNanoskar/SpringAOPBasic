package com.jayram.service;

import com.jayram.aspect.LoggingAspect;
import com.jayram.model.Triangle;

public class ShapeServiceProxy extends ShapeService { //ShapeServiceProxy class behaves like ShapeService but it is not actual ShapeService.
	
	public Triangle getTriangle() {
		new LoggingAspect().loggingAdvice(); //It is happening like before advice.
		return super.getTriangle(); //Calling actual method from Parent class
	}
}
