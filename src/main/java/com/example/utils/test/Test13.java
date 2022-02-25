package com.example.utils.test;

import com.example.utils.entity.ApplyExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @Author: Cc
 * @Date: 2021/12/8 9:39
 */
@Slf4j
public class Test13 {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*RestTemplate template = new RestTemplate();
        String url = "https://www.douban.com/group/shanghaizufang/";//上海租房小组
        String response = HttpUtil.get(url);
        log.info("response: {}", response);*/

        String a = "a";
        HashMap<String, Object> map = new HashMap<>();
        map.put("b","b");
        map.put("c","c");
        String d = (String)map.get("d");
        //System.out.println(a.equals(d));


        ApplyExcel excel = new ApplyExcel();
        excel.setPrice("");
        ApplyExcel clone =(ApplyExcel) excel.clone();
        System.out.println(excel == clone);
        System.out.println(excel.getTests() == clone.getTests());
    }
}
