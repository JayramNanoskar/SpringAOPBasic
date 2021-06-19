package com.jayram.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethod()")
	public void loggingAdvise(JoinPoint joinPoint){
		System.out.println("Advice run. Get method called. at "+ joinPoint.toString());
	}

	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice executed.");
	}

	@Pointcut("execution(public * get*(..))")
	public void allGetters(){}

	@Pointcut("within(com.jayram.model.*)") //Point cut expression to all classes present inside model package.
	public void allCircleMethod(){}
}
