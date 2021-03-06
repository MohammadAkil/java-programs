package com.te.service;


import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.te.dao.DaoStudentImpl;
import com.te.dto.Student;

@Component
public class ServiceLayer {
	
	ApplicationContext con = new ClassPathXmlApplicationContext("com\\te\\service\\config.xml");
	DaoStudentImpl dao = con.getBean("daoStudent",DaoStudentImpl.class);
	
	
	public boolean validate(Student student) {
		return dao.insert(student);
	}
	
	public boolean authenticate(String name, String password) {
		
		if(dao.getUserName(name).equals(password)) {
			System.out.println("authen method");
			return true;
		}
		
		return false;
	}
	
}
