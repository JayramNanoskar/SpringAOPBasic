package com.jayram.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public * get*(..))") //Using wild card expression to execute all getters irrespective of any return type & arguments.
	public void loggingAdvise(){
		System.out.println("Advice run. Get method called.");
	}
}
