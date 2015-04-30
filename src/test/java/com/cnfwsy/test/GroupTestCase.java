package com.cnfwsy.test;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.junit.Before;
import org.junit.Test;

public class GroupTestCase {
	ProcessEngine engine = null;

	@Before
	public void startWork() {
		System.out.println("=====startWork");
		// 加载配置文件activiti.cfg.xml，创建引擎，如果出现null，多半是加载路径不是根目录。
		// 获取配置文件后，引擎开始创建数据库。
		engine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void createGroup() {
		IdentityService identityService = engine.getIdentityService();
		createGroup(identityService, "1", "经理组", "typeManager");
	}
	
	@Test
	public void queryQuery() {
		IdentityService identityService = engine.getIdentityService();
		
		// 调用listPage方法，从索引为2的记录开始，查询3条记录
		List<Group> datas = identityService.createGroupQuery().list();
		
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}
		
		// 其他类似查询方法
		identityService.createGroupQuery().listPage(1, 3);// 分页返回查询结果
		identityService.createGroupQuery().count();// 结果总数
		identityService.createGroupQuery().groupName("managerA").singleResult();// 查询到多个时会抛出异常
		identityService.createGroupQuery().groupNameLike("%managerA%").singleResult();//
		
		identityService.createGroupQuery().groupId("1").singleResult();//
		identityService.createGroupQuery().groupType("typeA").singleResult();//
		identityService.createGroupQuery().orderByGroupId().asc().list();// 结果升序
		identityService.createGroupQuery().orderByGroupName().desc().list();// 结果降序
	}

	@Test
	public void deleteGroup() {
		IdentityService identityService = engine.getIdentityService();
		identityService.deleteGroup("1");
	}

	public void createGroup(IdentityService identityService, String id,
			String name, String type) {

		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}
//	
//	@After
//	public void endWork(){
//		System.out.println("=====endWork");
//		engine.close();
//	}
}
