package com.cnfwsy.test;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.identity.User;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class UserTestCase {
	private static Logger logger = Logger.getLogger(UserTestCase.class);
	private static ProcessEngine engine = null;

	@BeforeClass
	public static void startWork() {
		System.out.println("=====>startWork");
		engine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void createUser() {
		IdentityService identityService = engine.getIdentityService();
		User user = identityService.newUser("1");
		user.setId("2");
		user.setFirstName("zhang");
		user.setLastName("jianhua");
		user.setEmail("zhangjh@gmail.com");
		user.setPassword("123456");
		identityService.saveUser(user);

	}

	@Test
	public void queryUser() {
		IdentityService identityService = engine.getIdentityService();
		List<User> datas = identityService.createUserQuery().list();
		for (User user : datas) {
			System.out.println(user.getId() + " " + user.getFirstName());
		}
	}

	@Test
	public void checkPwd() {
		IdentityService identityService = engine.getIdentityService();
		boolean result = identityService.checkPassword("1", "用户密码");
		Assert.assertEquals(false, result);
	}

	@Test
	public void deleteUser() {
		IdentityService identityService = engine.getIdentityService();
		RuntimeService runtimeService = engine.getRuntimeService();
		HistoryService historyService = engine.getHistoryService();
		// 流程发起前设置发起人，记录在流程历史中
		identityService.setAuthenticatedUserId("kitty");
		// 开始流程
		runtimeService.startProcessInstanceByKey("XML中的ID");
		// 查询流程发起人
		logger.info(historyService.createHistoricProcessInstanceQuery()
				.startedBy("ketty").singleResult().getProcessDefinitionId());
	}

	@Test
	public void authenticate() {
		IdentityService identityService = engine.getIdentityService();
		identityService.setAuthenticatedUserId("2");
	}

	@AfterClass
	public static void endWork() {
		System.out.println("=====>endWork");
		engine.close();
	}
}
