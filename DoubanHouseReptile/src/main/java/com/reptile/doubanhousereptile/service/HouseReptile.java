package com.reptile.doubanhousereptile.service;

import cn.hutool.http.HttpUtil;
import com.citicsf.common.core.util.DateUtil;
import com.citicsf.common.core.util.gson.GsonUtils;
import com.reptile.doubanhousereptile.entity.HouseInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Cc
 * @Date: 2021/12/8 9:57
 */
@Slf4j
@Component
public class HouseReptile {

    //public String url = "https://www.douban.com/group/shanghaizufang/discussion?start=";//上海租房小组
    public String url = "https://www.douban.com/group/shanghaizufang/";//上海租房小组
    public String housePreUrl = "https://www.douban.com/group/topic";//租房贴前缀
    public String descriptionTag = "application/ld+json";//script标签 type属性
    //https://www.douban.com/group/shanghaizufang/discussion?start=50
    public int totalNum = 500;
    @Autowired
    private RestTemplate template;

    public void getInfo(HttpServletResponse response) {
        ArrayList<HouseInfo> houseListInfo = getHouseListInfo();
        ArrayList<HouseInfo> houseDetailInfo = getHouseDetailInfo(houseListInfo);
        createExcel(houseDetailInfo, response);
    }

    public ArrayList<HouseInfo> getHouseListInfo() {
        ArrayList<HouseInfo> houseInfoList = new ArrayList<>();
        HashMap<String, ArrayList> houseInfoMap = new HashMap<>();
        //for (int i = 25; i < totalNum; i += 25) {//只获取最新二十页的数据 每页25条
            //String temp = url + i;
            String response = HttpUtil.get(url);
            //log.info("response: {}", response);
            Document document = Jsoup.parse(response);
            Elements hrefElements = document.getElementsByTag("a");

            for (Element element : hrefElements) {
                String href = element.attr("href");
                if (href.contains(housePreUrl)) {
                    HouseInfo info = new HouseInfo();
                    info.setHouseUrl(href);
                    String title = element.attr("title");
                    info.setTitle(title);
                    houseInfoList.add(info);
                }
            }
        //}
        return houseInfoList;
    }

    // todo 根据详情过滤出描述信息，把图片转为base64给到另一个方法，生成excel

    public ArrayList<HouseInfo> getHouseDetailInfo(ArrayList<HouseInfo> houseInfoList) {
        if (null != houseInfoList && !houseInfoList.isEmpty()) {
            for (HouseInfo houseInfo : houseInfoList) {
                String houseDetailRes = HttpUtil.get(houseInfo.getHouseUrl());
                Document document = Jsoup.parse(houseDetailRes);
                Elements scripts = document.getElementsByTag("script");
                for (Element script : scripts) {
                    String type = script.attr("type");
                    if (descriptionTag.equals(type)) {
                        String data = script.data();
                        Map<String, Object> scriptDataMap = GsonUtils.strToMaps(data);
                        String text = (String) scriptDataMap.get("text");
                        LocalDateTime dataCreateTime = (LocalDateTime) scriptDataMap.get("dateCreated");
                        houseInfo.setDescription(text);
                        houseInfo.setCreateTime(dataCreateTime);
                    }
                }
            }
        }
        return houseInfoList;
    }

    public void createExcel(ArrayList<HouseInfo> houseInfoList, HttpServletResponse response) {
        try (
                OutputStream out = response.getOutputStream()
        ) {
            SXSSFWorkbook workbook = new SXSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            int rowNum = 1;
            for (HouseInfo info : houseInfoList) {
                Row row = sheet.createRow(rowNum);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(info.getTitle());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(info.getDescription());
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(info.getCreateTime().toString());
                rowNum++;
            }
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF8");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + com.citicsf.common.core.util.DateUtil.date2String(new Date(), DateUtil.PATTERN1[3]) + ".xlsx\"");
            workbook.write(out);
        } catch (Exception e) {
            log.info("Excel生成失败", e);
        }
    }
}
