package com.example.utils.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.common.core.util.gson.GsonUtils;
import com.example.utils.entity.ApplyExcelVO;
import com.google.gson.reflect.TypeToken;

/**
 * @Author: Cc
 * @Date: 2021/11/27 16:05
 */
public class Test10 {
    public static void main(String[] args) {
        String json = "{\"code\":\"000000\",\"message\":\"成功\",\"data\":{\"excelInfo\":[{\"receiptNumber\":\"啊\",\"transferNum\":\"1\",\"transferPrice\":\"1\",\"weight\":\"1\",\"price\":\"1\"},{\"receiptNumber\":\"1\",\"transferNum\":\"1\",\"transferPrice\":\"1\",\"weight\":\"1\",\"price\":\"1\"},{\"receiptNumber\":\"1\",\"transferNum\":\"1\",\"transferPrice\":\"1\",\"weight\":\"1\",\"price\":\"1\"}]}}";

        BaseResponse<ApplyExcelVO> parseObject1 = GsonUtils.fromJson(json, new TypeToken<BaseResponse<ApplyExcelVO>>() {}.getRawType());
        //BaseResponse<ApplyExcelVO> parseObject2 = GsonUtils.fromJson(json, BaseResponse.class);
        BaseResponse<ApplyExcelVO> parseObject3 = JSON.parseObject(json, new TypeReference<BaseResponse<ApplyExcelVO>>() {
        });

        //String newJson1 = GsonUtils.toJsonStringWithUnderscores(parseObject1);
        String newJson2 = GsonUtils.toJsonStringWithUnderscores(parseObject3);

        //System.out.println("1: " + newJson1);
        System.out.println("2: " + newJson2);




        //System.out.println(parseObject2.getData().getClass());
        //System.out.println(parseObject1.getClass());

    }
}
