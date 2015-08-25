package com.skysport.inerfaces.action.system;

import com.skysport.core.action.BaseAction;
import com.skysport.core.bean.query.DataTablesInfo;
import com.skysport.core.bean.system.SelectItem2;
import com.skysport.core.constant.DictionaryKeyConstant;
import com.skysport.core.instance.DictionaryInfo;
import com.skysport.core.utils.PrimaryKeyUtils;
import com.skysport.inerfaces.bean.system.permission.UserInfo;
import com.skysport.inerfaces.model.permission.userinfo.helper.UserInfoHelper;
import com.skysport.inerfaces.model.permission.userinfo.service.IUserInfoService;
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
 * 类说明:
 * Created by zhangjh on 2015/8/17.
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/userinfo")
public class UserInfoAction extends BaseAction<String, Object, UserInfo> {
    Logger log = Logger.getLogger(UserInfoAction.class);
    @Resource(name = "userInfoService")
    private IUserInfoService userInfoService;


    /**
     * 此方法描述的是：展示list页面	 *
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:34:53
     */
    @RequestMapping(value = "/add/{natrualKey}")
    @ResponseBody
    public ModelAndView add(@PathVariable String natrualKey)  {
        ModelAndView mav = new ModelAndView("/system/permission/user-edit");
        mav.addObject("natrualkey", natrualKey);
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
             {
        // HashMap<String, String> paramMap = convertToMap(params);
        DataTablesInfo dataTablesInfo = convertToDataTableQrInfo(DictionaryKeyConstant.USERINFO_TABLE_COLULMN, request);
        // 总记录数
        int recordsTotal = userInfoService.listInfosCounts();
        int recordsFiltered = recordsTotal;
        if (!StringUtils.isBlank(dataTablesInfo.getSearchValue())) {
            recordsFiltered = userInfoService.listFilteredInfosCounts(dataTablesInfo);
        }
        int draw = Integer.parseInt(request.getParameter("draw"));
        List<UserInfo> infos = userInfoService.searchInfos(dataTablesInfo);
        UserInfoHelper.SINGLETONE.turnSomeIdToNameInList(infos);
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
    public Map<String, Object> edit(UserInfo userinfoInfo)  {
        userInfoService.edit(userinfoInfo);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "更新成功");
        return resultMap;
    }

    @RequestMapping(value = "/add/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("fileLocation") MultipartFile[] fileLocation, HttpServletRequest request) {
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

        // 重定向
        return resultMap;
    }

    /**
     * 此方法描述的是：
     *
     * @author: zhangjh
     * @version: 2015年4月29日 下午5:35:09
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(UserInfo userinfoInfo)  {
        //设置ID
        userinfoInfo.setNatrualkey(PrimaryKeyUtils.getUUID());
        UserInfoHelper.SINGLETONE.encriptPwd(userinfoInfo);
        userInfoService.add(userinfoInfo);
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
    public UserInfo queryCustomerNo(@PathVariable String natrualKey) {
        UserInfo userinfoInfo = userInfoService.queryInfoByNatrualKey(natrualKey);
        return userinfoInfo;
    }

    /**
     * @param natrualKey
     * @return
     */
    @RequestMapping(value = "/del/{natrualKey}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> del(@PathVariable String natrualKey) {
        userInfoService.del(natrualKey);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", "0");
        resultMap.put("message", "删除成功");
        return resultMap;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> querySelectList(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<SelectItem2> commonBeans = userInfoService.querySelectList(name);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("items", commonBeans);
        resultMap.put("total_count", commonBeans.size());
        return resultMap;
    }


    @RequestMapping(value = "/usertype", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> queryUserType(HttpServletRequest request) {
        Map<String, String> resultMap = DictionaryInfo.SINGLETONE.getValueMapByTypeKey(DictionaryKeyConstant.USER_TYPE);
        return resultMap;
    }


}
