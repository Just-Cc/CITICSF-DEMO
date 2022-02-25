package com.example.utils.test;

import cn.hutool.json.JSONUtil;

import java.util.HashMap;

/**
 * @Author: Cc
 * @Date: 2021/11/2 20:03
 */
public class Test5 {
    public static void main(String[] args) {
        String missionCode = "";
        String wholeFlag = "0";

        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map1.put("op_branch_no", "0");
        map1.put("operator_no", "admin");
        map1.put("op_password", "AX60hgWc3tbpTAxqbGRvo6MD#354F");
        map1.put("op_station", "pc");
        map1.put("op_entrust_way ", "9");
        map1.put("acpt_id", missionCode==null?"":missionCode);
        map1.put("acpt_busin_kind", "80");
        map1.put("acpt_busin_id", "806902");
        map1.put("acpt_enroute_field", "");
        map1.put("branch_no", "");
        map1.put("client_id", "");
        map1.put("full_name", "测试fullName");
        map1.put("id_kind", "0");
        map1.put("id_no", "320826199302160476");
        map1.put("organ_flag", "");
        map1.put("whole_flag", wholeFlag);
        map2.put("business_data", JSONUtil.toJsonStr(map1));
        System.out.println("map1: " + JSONUtil.toJsonStr(map1));

        System.out.println("map2: " + JSONUtil.toJsonStr(map2));
    }
}
