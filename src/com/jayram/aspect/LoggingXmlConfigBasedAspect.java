package com.jayram.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingXmlConfigBasedAspect {
	
	public void myAdvice(){
		System.out.println("Third Advice executed.");
	}
	
}
