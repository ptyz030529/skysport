package com.cnfwsy.test;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

public class BaseTestCase {
	ProcessEngine engine = null;

	@Before
	public void startWork() {
		// 加载配置文件activiti.cfg.xml，创建引擎，如果出现null，多半是加载路径不是根目录。
		// 获取配置文件后，引擎开始创建数据库。
		engine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void t1() {

		// 获取流程储存服务组件
		RepositoryService repositoryService = engine.getRepositoryService();

		// 获取运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();

		// 获取流程中的任务TASK组件
		TaskService taskService = engine.getTaskService();

		// 部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署
		repositoryService.createDeployment()
				.addClasspathResource("MYprocess.bpmn").deploy();

		// 开启流程，myprocess是流程的ID
		runtimeService.startProcessInstanceByKey("myProcess");

		// 利用taskservice进行任务查询，查询第一个任务，查询后完成
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("第一个流程任务完成前：" + task.getName());
		taskService.complete(task.getId());

		// 完成第一个任务后再次查询，出现第二个任务名称，完成第二个任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("第二个流程任务完成前：" + task.getName());
		taskService.complete(task.getId());

		// 再次查询，TASK是NULL
		task = taskService.createTaskQuery().singleResult();
		System.out.println("结束后" + task);

	}
	
	
	
	@Test
	public void createGroup() {
		IdentityService identityService = engine.getIdentityService();
		createGroup(identityService, "1", "经理组", "typeManager");

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
}
