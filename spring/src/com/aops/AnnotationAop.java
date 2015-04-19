package com.aops;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotationAop {

	@Pointcut("execution (* com.test.Test.fun(..))")
	public void fun(){};
	
	@Before("fun()")
	public void before()
	{
		System.out.println("I'm from annotation AOP'S after function");
	}
	
	@After("fun()")
	public void after()
	{
		System.out.println("I'm from annotation AOP'S before function");
	}
	
	@Around("fun()")
	public void around(ProceedingJoinPoint jonPoint)
	{
		
		try {
			System.out.println("around before");
			jonPoint.proceed();
			System.out.println("around after");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
}
