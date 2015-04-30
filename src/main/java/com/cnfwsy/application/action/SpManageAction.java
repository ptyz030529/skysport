package com.cnfwsy.application.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnfwsy.application.bean.SpInfo;
import com.cnfwsy.application.business.system.sp.service.SpManageService;
import com.cnfwsy.test.model.TestModel;

/**
 * 
 * 此类描述的是：
 * 
 * @author: zhangjh
 * @version: 2015年4月29日 下午5:34:47
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/sp")
public class SpManageAction {
	
	@Autowired
	private SpManageService spManageService;

	/**
	 * 
	 * 此方法描述的是：
	 * 
	 * @author: zhangjh
	 * @version: 2015年4月29日 下午5:34:53
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public ModelAndView listSP(SpInfo spInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	    List<SpInfo> spInfos = spManageService.listSP();
		ModelAndView mav = new ModelAndView("/system/sp/list", map);
		return mav;
	}

	/**
	 * 
	 * 此方法描述的是：
	 * 
	 * @author: zhangjh
	 * @version: 2015年4月29日 下午5:35:09
	 */
	@RequestMapping(value = "/edit/{spId}")
	@ResponseBody
	public ModelAndView querySPInfo(SpInfo spInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("/system/sp/edit");
		return mav;
	}

	public SpManageService getSpManageService() {
		return spManageService;
	}

	public void setSpManageService(SpManageService spManageService) {
		this.spManageService = spManageService;
	}

}
