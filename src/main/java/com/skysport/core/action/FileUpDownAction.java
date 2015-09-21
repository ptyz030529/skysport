package com.skysport.core.action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2015/9/15.
 */
@Scope("prototype")
@Controller
@RequestMapping("/file")
public class FileUpDownAction {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @param fileLocation
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
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
                    logger.error("保存上传文件异常", e);
                }
            }
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 重定向
        return resultMap;
    }


    /**
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @param fileLocation
     * @return
     */
    @RequestMapping(value = "/uploada", method = RequestMethod.POST)
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
                    logger.error("保存上传文件异常", e);
                }
            }
        }
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 重定向
        return resultMap;
    }






}
