package com.skysport.inerfaces.action.develop;

import com.skysport.core.action.BaseAction;
import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.constant.DictionaryTypeConstant;
import com.skysport.core.model.seqno.service.IncrementNumber;
import com.skysport.inerfaces.bean.ProjectBomInfo;
import com.skysport.inerfaces.constant.SystemInfoConstant;
import com.skysport.inerfaces.form.develop.ProjectQueryForm;
import com.skysport.inerfaces.helper.BuildSeqNoHelper;
import com.skysport.inerfaces.model.develop.bom.IBomManageService;
import com.skysport.inerfaces.model.develop.bom.helper.BomManageHelper;
import com.skysport.inerfaces.model.develop.project.helper.ProjectManageHelper;
import com.skysport.inerfaces.model.develop.project.service.IProjectManageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
public class ProjectAction extends BaseAction<String, Object, ProjectBomInfo> {
    Logger log = Logger.getLogger(ProjectAction.class);
    @Resource(name = "projectManageService")
    private IProjectManageService projectManageService;
    @Resource(name = "bomManageService")
    private IBomManageService bomManageService;
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
        ModelAndView mav = new ModelAndView("/development/project/project-list");
        return mav;
    }

    /**
     * 此方法描述的是：展示add页面
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/add/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView add(@PathVariable String natrualKey) throws Exception {

        ModelAndView mav = new ModelAndView("/development/project/project-add");
        mav.addObject("natrualkey", natrualKey);
        return mav;
    }


    /**
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @param fileLocation
     * @return
     */
    @RequestMapping(value = "/add/{natrualKey}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(@RequestParam("fileLocation") MultipartFile[] fileLocation, HttpServletRequest request) {
        for (MultipartFile file : fileLocation) {
            // 判断文件是否为空
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
//                    String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
                    String filePath = "D:\\work\\project\\upload\\skysport\\project\\" + file.getOriginalFilename();
                    File emptyFile = new File(filePath);
                    if (!emptyFile.exists()) {
                        emptyFile.createNewFile();
                    }
                    // 转存文件
                    file.transferTo(emptyFile);
                } catch (Exception e) {
                    log.error("保存上传文件异常", e);
                }
            }
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
//        String[] initialPreview = new String[1];
//        initialPreview[0] = "<img src='/resources/images/desert.jpg' class='file-preview-image' alt='Desert' title='Desert'>";
//        resultMap.put("initialPreview", initialPreview);
//        PreviewConfig initialPreviewConfig = new PreviewConfig();
//        initialPreviewConfig.setCaption("desert.jpg");
//        initialPreviewConfig.setExtra(new Extra(100));
//        initialPreviewConfig.setKey("100");
//        initialPreviewConfig.setUrl("http://localhost/avatar/delete");
//        initialPreviewConfig.setWidth("120px");
//        resultMap.put("initialPreviewConfig", initialPreviewConfig);
        // 重定向
        return resultMap;
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
        ProjectQueryForm queryForm = new ProjectQueryForm();
        queryForm.setDataTablesInfo(convertToDataTableQrInfo(DictionaryTypeConstant.PROJECT_TABLE_COLULMN, request));
        ProjectBomInfo bomInfo = new ProjectBomInfo();
        bomInfo.setYearCode(request.getParameter("yearCode"));
        bomInfo.setCustomerId(request.getParameter("customerId"));
        bomInfo.setAreaId(request.getParameter("areaId"));
        bomInfo.setSeriesId(request.getParameter("seriesId"));
        queryForm.setProjectBomInfo(bomInfo);
        ProjectManageHelper.buildBomQueryForm(queryForm, request);
        // 总记录数
        int recordsTotal = projectManageService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(queryForm.getDataTablesInfo().getSearchValue())) {
            recordsFiltered = projectManageService.listFilteredInfosCounts(queryForm);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<ProjectBomInfo> infos = projectManageService.searchInfos(queryForm);
        ProjectManageHelper.turnIdToName(infos);
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
    public Map<String, Object> edit(ProjectBomInfo info) throws Exception {
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
        BomManageHelper.autoCreateBomInfoAndSave(bomManageService, incrementNumber, info);


        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "新增成功");
        return resultMap;

    }


    /**
     * @param natrualKey 主键id
     * @return 根据主键id找出详细信息
     */
    @RequestMapping(value = "/info/{natrualKey}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectBomInfo queryCustomerNo(@PathVariable String natrualKey) {
        ProjectBomInfo info = projectManageService.queryInfoByNatrualKey(natrualKey);
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
        List<SelectItem2> commonBeans = projectManageService.querySelectList(name);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("items", commonBeans);
        resultMap.put("total_count", commonBeans.size());
        return resultMap;
    }


    /**
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @param files
     * @return
     */
    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        for (MultipartFile file : files) {
            // 判断文件是否为空
            if (!file.isEmpty()) {
                try {
                    // 文件保存路径
                    String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                            + file.getOriginalFilename();
                    // 转存文件
                    file.transferTo(new File(filePath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 重定向
        return "redirect:/list.html";
    }


    /**
     * 读取上传文件中得所有文件并返回
     *
     * @return
     */
    @RequestMapping("file-list")
    public ModelAndView list(HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        ModelAndView mav = new ModelAndView("list");
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
            System.out.println(fileNames[i]);
        }
        return mav;
    }


}
