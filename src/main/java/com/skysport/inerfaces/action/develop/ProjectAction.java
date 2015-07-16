package com.skysport.inerfaces.action.develop;

import com.skysport.core.action.TableListQueryAction;
import com.skysport.core.bean.system.SelectItem;
import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.BomInfo;
import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.constant.SystemInfoConstant;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.bom.helper.BomManageHelper;
import com.skysport.inerfaces.model.develop.project.helper.ProjectManageHelper;
import com.skysport.inerfaces.model.develop.project.service.IProjectManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目
 * Created by zhangjh on 2015/6/23.
 */
@Scope("prototype")
@Controller
@RequestMapping("/development/project")
public class ProjectAction extends TableListQueryAction<String, Object, ProjectBomInfo> {
    @Resource(name = "projectManageService")
    private IProjectManageService projectManageService;
    @Resource(name = "bomManageService")
    private IBomManageService<BomInfo> bomManageService;

    @Resource(name = "incrementNumber")
    private IncrementNumber incrementNumber;


    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public ModelAndView search() throws Exception {
        ModelAndView mav = new ModelAndView("/development/project/list");
        return mav;
    }

    /**
     * 此方法描述的是：展示add页面
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public ModelAndView add() throws Exception {
        ModelAndView mav = new ModelAndView("/development/project/project-add");
        return mav;
    }

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Map<String, Object> search(HttpServletRequest request)
            throws Exception {
        //组件queryFory的参数
        ProjectQueryForm queryForm = (ProjectQueryForm) convertToDataTableQrInfo(DictionaryTypeConstant.PROJECT_TABLE_COLULMN, request);
        ProjectManageHelper.buildBomQueryForm(queryForm, request);
        // 总记录数
        int recordsTotal = projectManageService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(queryForm.getSearchValue())) {
            recordsFiltered = projectManageService.listFilteredInfosCounts(queryForm);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<ProjectBomInfo> infos = projectManageService.searchInfos(queryForm);
        Map<String, Object> resultMap = buildSearchJsonMap(infos, recordsTotal, recordsFiltered, draw);
        return resultMap;
    }

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> edit(ProjectBomInfo info, HttpServletRequest request) throws Exception {
        projectManageService.edit(info);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "更新成功");
        return resultMap;
    }


    /**
     * 此方法描述的是：项目新增
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(ProjectBomInfo info) throws Exception {

        String currentNo = projectManageService.queryCurrentSeqNo(info);
        String kind_name = ProjectManageHelper.buildKindName(info);
        String seqNo = BuildSeqNoHelper.SINGLETONE.getFullSeqNo(kind_name, incrementNumber, SystemInfoConstant.PROJECT_SEQ_NO_LENGTH);
        //年份+客户+地域+系列+NNN
        String projectId = kind_name + seqNo;

        //设置ID
        info.setNatrualkey(projectId);
        info.setSeqNo(seqNo);

        //保存项目信息
        projectManageService.add(info);


        //生成BOM信息并保存
        BomManageHelper.autoCreateBomInfoAndSave(bomManageService, info);


        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;

    }


    /**
     * @param natrualKey 主键id
     * @param request    请求信息
     * @return 根据主键id找出详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectBomInfo queryCustomerNo(@PathVariable String natrualKey, HttpServletRequest request, HttpServletResponse reareaonse) {
        ProjectBomInfo info = (ProjectBomInfo) projectManageService.queryInfoByNatrualKey(natrualKey);
        return info;
    }

    /**
     * @param natrualKey
     * @return
     */
    @RequestMapping(value = "/del/{natrualKey}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String natrualKey) {
        projectManageService.del(natrualKey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> querySelectList(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<SelectItem> commonBeans = projectManageService.querySelectList(name);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("items", commonBeans);
        resultMap.put("total_count", commonBeans.size());
        return resultMap;
    }

}
