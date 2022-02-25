package com.example.utils.entity;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;

/**
 * @Author: Cc
 * @Date: 2021/5/21 13:41
 */
@Data
public class ApplyExcel implements Serializable,Cloneable {

    //仓单号
    private String receiptNumber;
    //转让数量(张)
    private String transferNum;
    //转让价格（元/合约单位）
    private String transferPrice;
    //重量
    private String weight;
    //货款
    private String price;

    private TestDTO tests;

    @Override
    public Object clone() throws CloneNotSupportedException {
        ApplyExcel excel = (ApplyExcel)super.clone();
        excel.tests = (TestDTO)tests.clone();
        return excel;
    }
}
