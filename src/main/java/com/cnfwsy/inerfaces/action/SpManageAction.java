package com.cnfwsy.inerfaces.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cnfwsy.core.action.CommonAction;
import com.cnfwsy.core.bean.DataTablesInfo;
import com.cnfwsy.inerfaces.bean.SpInfo;
import com.cnfwsy.inerfaces.model.system.sp.service.ISpManageService;

/**
 * 
 * �����������ǣ�
 * 
 * @author: zhangjh
 * @version: 2015��4��29�� ����5:34:47
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/sp")
public class SpManageAction extends CommonAction<String, Object, SpInfo> {
	@Resource(name = "spManageService")
	private ISpManageService spManageService;
	/**
	 * �˷����������ǣ�չʾlistҳ��	 * 
	 * @author: zhangjh
	 * @version: 2015��4��29�� ����5:34:53
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public ModelAndView search() throws Exception {
		ModelAndView mav = new ModelAndView("/system/sp/list2");
		return mav;
	}
	/**
	 * �˷����������ǣ�
	 * @author: zhangjh
	 * @version: 2015��4��29�� ����5:34:53
	 */
	@RequestMapping(value = "/search")
	@ResponseBody
	public Map<String, Object> search(HttpServletRequest request)
			throws Exception {
		// HashMap<String, String> paramMap = convertToMap(params);
		DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(request);
		
		
		// �ܼ�¼��
		int recordsTotal = spManageService.listSPInfosCounts();
		int recordsFiltered = recordsTotal;
		if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
			recordsFiltered = spManageService
					.listFilteredSPInfosCounts(dataTablesInfo);
		}
		int draw = Integer.parseInt(request.getParameter("draw"));
		List<SpInfo> spInfos = spManageService.searchSP(dataTablesInfo);
		Map<String, Object> resultMap = buildSearchJsonMap(spInfos,
				recordsTotal, recordsFiltered, draw);

		// ModelAndView mav = new ModelAndView("/system/sp/list2", resultMap);

		// return mav;
		return resultMap;
	}

	/**
	 * 
	 * �˷����������ǣ�
	 * 
	 * @author: zhangjh
	 * @version: 2015��4��29�� ����5:35:09
	 */
	@RequestMapping(value = "/edit/{spId}")
	@ResponseBody
	public ModelAndView querySPInfo(SpInfo spInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("/system/sp/edit");
		return mav;
	}

}
