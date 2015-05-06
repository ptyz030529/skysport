package com.cnfwsy.core.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cnfwsy.core.model.init.helper.SystemInitHelper;

/**
 * �������������ֶε���Ϣ
 * @author: zhangjh
 * @version:2015��5��6�� ����2:49:25
 */
public class InitSytemInfoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// spring ������
		ApplicationContext appContext = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		
				
		SystemInitHelper.SINGLETONE.init(appContext);
		
		
		/*
		 * ServiceBean bean1=appContext.getBean("xxx"); ...ҵ�񷽷������������ֵ�ȡ�
		 */

	}

}
