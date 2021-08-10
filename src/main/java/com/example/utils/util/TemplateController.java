package com.example.utils.util;

import cn.hutool.json.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Cc
 * @Date: 2021/5/31 9:36
 */
@Controller
@RequestMapping("excel")
public class TemplateController {

    @RequestMapping(value = "downLoadStuInfoExcel", produces = "text/html;charset=UTF-8")
    public void downLoadStuInfoExcel(HttpServletResponse response, HttpServletRequest request) {
        JSONObject rt = new JSONObject();
        //json对象，用来记录下载状态值，写入log中，也可以把状态值返回到前台，这一部分可有可无。
        /*rt.put("status", "1");
        rt.put("message", "");
        rt.put("result", "");*/
        //学生新建excel下载模板保存地址从配置文件中读取
        //String folderPath = ResourceBundle.getBundle("systemconfig").getString("stuExcelDownLoadPath") + File.separator + "stuTemplateExcel.xlsx";
        String folderPath = "/excel/transferTemplate.xlsx";
        File excelFile = new File(folderPath);
        //判断模板文件是否存在
        if (!excelFile.exists() || !excelFile.isFile()) {
            rt.put("status", "0");
            rt.put("message", "模板文件不存在");

            //  return rt.toJSONString();
        }
        //文件输入流
        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        //使用XSSFWorkbook对象读取excel文件
        try {
            fis = new FileInputStream(excelFile);
            wb = new XSSFWorkbook(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            rt.put("status", "0");
            rt.put("message", "模板文件读取失败");
            // return rt.toJSONString();
        }
        //设置contentType为vnd.ms-excel
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        // 对文件名进行处理。防止文件名乱码，这里前台直接定义了模板文件名，所以就不再次定义了
        //String fileName = CharEncodingEdit.processFileName(request, "stuTemplateExcel.xlsx");
        // Content-disposition属性设置成以附件方式进行下载
        response.setHeader("Content-disposition", "attachment;filename=stuTemplateExcel.xlsx");
        //调取response对象中的OutputStream对象
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            rt.put("status", "0");
            rt.put("message", "模板文件下载失败");
        }
        //return rt.toJSONString();
    }
}
