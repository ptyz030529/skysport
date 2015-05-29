package com.skysport.test;

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
		// ���������ļ�activiti.cfg.xml���������棬�������null������Ǽ���·�����Ǹ�Ŀ¼��
		// ��ȡ�����ļ������濪ʼ�������ݿ⡣
		engine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void t1() {

		// ��ȡ���̴���������
		RepositoryService repositoryService = engine.getRepositoryService();

		// ��ȡ����ʱ�������
		RuntimeService runtimeService = engine.getRuntimeService();

		// ��ȡ�����е�����TASK���
		TaskService taskService = engine.getTaskService();

		// �������̣�ֻҪ�Ƿ���BPMN2�淶��XML�ļ��������϶����Ա�ACTIVITI����
		repositoryService.createDeployment()
				.addClasspathResource("MYprocess.bpmn").deploy();

		// �������̣�myprocess�����̵�ID
		runtimeService.startProcessInstanceByKey("myProcess");

		// ����taskservice���������ѯ����ѯ��һ�����񣬲�ѯ�����
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("��һ�������������ǰ��" + task.getName());
		taskService.complete(task.getId());

		// ��ɵ�һ��������ٴβ�ѯ�����ֵڶ����������ƣ���ɵڶ�������
		task = taskService.createTaskQuery().singleResult();
		System.out.println("�ڶ��������������ǰ��" + task.getName());
		taskService.complete(task.getId());

		// �ٴβ�ѯ��TASK��NULL
		task = taskService.createTaskQuery().singleResult();
		System.out.println("������" + task);

	}
	
	
	
	@Test
	public void createGroup() {
		IdentityService identityService = engine.getIdentityService();
		createGroup(identityService, "1", "������", "typeManager");

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
