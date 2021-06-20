package com.jayram.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethod()")
	public void loggingAdvise(JoinPoint joinPoint){
		System.out.println("Advice run. Get method called. at "+ joinPoint.toString());
	}

	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void StringArgumentMethods(String name, String returnString){
		System.out.println("A method that takes String argument has been called. The value is "+name+" and The output value is "+returnString);
	}

	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex){
		System.out.println("An excepetion has been thrown "+ex.toString());
	}

	@Around("@annotation(com.jayram.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed(); //calling target method
			System.out.println("After returning");
		} catch (Throwable e) {
			System.out.println("After throwing");
			e.printStackTrace();
		}
		System.out.println("After finally");
		return returnValue;
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
