package com.example.utils.entity;

import java.io.Serializable;

/**
 * @Author: Cc
 * @Date: 2021/5/21 13:41
 */
public class ApplyExcel implements Serializable {

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

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(String transferNum) {
        this.transferNum = transferNum;
    }

    public String getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
