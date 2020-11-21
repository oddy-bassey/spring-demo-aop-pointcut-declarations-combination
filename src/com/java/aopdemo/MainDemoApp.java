package com.java.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.Account;
import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		//read spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the AccountDAO bean from spring container
		AccountDAO accDao = context.getBean("accountDAO", AccountDAO.class);
		
		//get the MembershipDAO bean from spring container
		MembershipDAO memDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		
		//call the business method
		accDao.addAccount(account, true); 
		System.out.println(accDao.personAccount()+"\n");
		
		//calling account getter and setter methods
		accDao.setName("Revolt");
		accDao.setServiceCode("98765");
		
		accDao.getName();
		accDao.getServiceCode();
		
		//call the business method
		memDao.addAccount();
		System.out.println(memDao.getMemberCode()+"\n");
		
		//close the
		context.close();
	}
}
