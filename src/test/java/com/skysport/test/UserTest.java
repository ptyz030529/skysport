package com.skysport.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skysport.core.bean.permission.User;
import com.skysport.core.model.login.service.IUserService;

public class UserTest {
	IUserService userService;

	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });
		userService = (IUserService) context.getBean("userServiceImpl");
	}

	@Test
	public void addUser() {
		User user = new User();
	
	}

}
