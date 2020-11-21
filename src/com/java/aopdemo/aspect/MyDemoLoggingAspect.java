package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	//An aspect is a java class that has some collection of related advices
	
	//@Before("execution(public void com.java.aopdemo.dao.AccountDAO.addAccount())") matching on qualified class name
	//@Before("execution(public void addAccount())") matching on any addAccount() method
	//@Before("execution(public void add*())") matching on any method starting with add...() with a public access identifier and void return type
	//@Before("execution(void add*())") matching on any method starting with add...() and void return type
	//@Before("execution(* add*())") matching on any method starting with add...() and any return type
	//@Before("execution(* add*(com.java.aopdemo.dao.Account))") Matching on method with "com.java.aopdemo.dao.Account" parameter
	//@Before("execution(* add*(com.java.aopdemo.dao.Account, ..))") Matching on method with any number of parameters
	
	/*@Before("execution(* com.java.aopdemo.dao.*.*(..))") Matching on method in a given package
	 * 
	 * Match pattern: any return type -> in com.java.aopdemo.dao. package -> in any class -> any method (any paramter length)
	 */
	
	//create pointcut for all methods in the package "com.java.aopdemo.dao.*.*(..)" with any parameter list length 
	@Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
	private void getters() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
	private void setters() {}
	
	//create pointcut to include the package methods, excluding getters and setters
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("==>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("==>> Performing API analytics");
	}
}























