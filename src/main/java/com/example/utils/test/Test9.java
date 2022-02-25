package com.example.utils.test;

import com.citicsf.common.core.util.gson.GsonUtils;
import com.example.utils.entity.CancellationApplyExcelDTO;
import com.example.utils.entity.CancellationExcelDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2021/11/25 16:07
 */
public class Test9 {
    public static void main(String[] args) {
        CancellationApplyExcelDTO cancelDTO = new CancellationApplyExcelDTO();
        CancellationExcelDTO excelDTO = new CancellationExcelDTO();
        excelDTO.setOther("dsfaafd");
        excelDTO.setCancelNumber("dsq");
        excelDTO.setPickUpArea("afa");
        excelDTO.setWarehouseBranch("aDGAGadsg");
        excelDTO.setWarehouseNo("dsafadsfsa");
        excelDTO.setWarehouseType("s4teqw");
        excelDTO.setWarehouseReceiptNo("fasSF_afs_Af_");


        cancelDTO.setCancelCount("asdfas");
        cancelDTO.setExchangeCode("dsafaqwreq");
        cancelDTO.setProdCode("dsfaqetrwq");
        cancelDTO.setStorageCharges("5163165");
        List<CancellationExcelDTO> excelDTOList = new ArrayList<CancellationExcelDTO>();
        excelDTOList.add(excelDTO);
        cancelDTO.setCancellationExcelInfo(excelDTOList);

        String json = GsonUtils.toJsonString(cancelDTO);
        System.out.println("驼峰：" + json);

        //String newJson = Test8.humpToLine2(json);
        GsonBuilder gb = new GsonBuilder();
        gb.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gb.create();
        String newJson = gson.toJson(cancelDTO);
        System.out.println("下划线： " + newJson);
    }
}
