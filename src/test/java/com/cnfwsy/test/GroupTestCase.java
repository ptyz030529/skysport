package com.skysport.test;

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
		// ���������ļ�activiti.cfg.xml���������棬�������null������Ǽ���·�����Ǹ�Ŀ¼��
		// ��ȡ�����ļ������濪ʼ�������ݿ⡣
		engine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void createGroup() {
		IdentityService identityService = engine.getIdentityService();
		createGroup(identityService, "1", "������", "typeManager");
	}
	
	@Test
	public void queryQuery() {
		IdentityService identityService = engine.getIdentityService();
		
		// ����listPage������������Ϊ2�ļ�¼��ʼ����ѯ3����¼
		List<Group> datas = identityService.createGroupQuery().list();
		
		for (Group data : datas) {
			System.out.println(data.getId() + "---" + data.getName() + " ");
		}
		
		// �������Ʋ�ѯ����
		identityService.createGroupQuery().listPage(1, 3);// ��ҳ���ز�ѯ���
		identityService.createGroupQuery().count();// �������
		identityService.createGroupQuery().groupName("managerA").singleResult();// ��ѯ�����ʱ���׳��쳣
		identityService.createGroupQuery().groupNameLike("%managerA%").singleResult();//
		
		identityService.createGroupQuery().groupId("1").singleResult();//
		identityService.createGroupQuery().groupType("typeA").singleResult();//
		identityService.createGroupQuery().orderByGroupId().asc().list();// �������
		identityService.createGroupQuery().orderByGroupName().desc().list();// �������
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
