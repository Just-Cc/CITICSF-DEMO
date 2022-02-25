package com.example.utils.test;

import cn.hutool.json.JSONUtil;
import com.citicsf.common.core.util.gson.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @Author: Cc
 * @Date: 2021/12/7 16:45
 */
@Slf4j
public class Test12 {
    public static void main(String[] args) {
        String missionCode = "";
        String wholeFlag = "0";

        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map1.put("op_branch_no", "0");
        map1.put("operator_no", "admin");
        map1.put("op_password", "AX60hgWc3tbpTAxqbGRvo6MD#354F");
        map1.put("op_station", "pc");
        map1.put("op_entrust_way", "9");
        //map1.put("acpt_id", missionCode==null?"":missionCode);
        map1.put("acpt_busin_kind", "80");
        map1.put("acpt_busin_id", "806902");
        map1.put("acpt_enroute_field", "");
        //map1.put("branch_no", "");
        //map1.put("client_id", "");
        map1.put("full_name", "测试fullName");
        map1.put("id_kind", "0");
        map1.put("id_no", "320826199302160476");
        //map1.put("organ_flag", "");
        map1.put("whole_flag", wholeFlag);
        map1.put("func_account","资金账号");
        map1.put("business_data", JSONUtil.toJsonStr(map1));
        map1.remove("func_account");
        System.out.println("map1: " + JSONUtil.toJsonStr(map1));

        //System.out.println("map2: " + JSONUtil.toJsonStr(map2));

        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(reqJson, headers);
        String bpsUrl = "http://10.21.2.156:8088/g/hsbroker.pes/v/getAcptformCheckOut";
        RestTemplate template = new RestTemplate();
        String responseString = template.postForObject(bpsUrl, httpEntity, String.class);
        log.info("response: {}", responseString);*/
        //Map<String, Object> stringObjectMap = GsonUtils.strToMaps(responseString);
    }
}
