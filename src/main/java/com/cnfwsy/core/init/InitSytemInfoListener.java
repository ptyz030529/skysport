package com.cnfwsy.core.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cnfwsy.core.model.init.helper.SystemInitHelper;

/**
 * 启动加载数据字段等信息
 * @author: zhangjh
 * @version:2015年5月6日 下午2:49:25
 */
public class InitSytemInfoListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// spring 上下文
		ApplicationContext appContext = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		
				
		SystemInitHelper.SINGLETONE.init(appContext);
		
		
		/*
		 * ServiceBean bean1=appContext.getBean("xxx"); ...业务方法，加载数据字典等。
		 */

	}

}
