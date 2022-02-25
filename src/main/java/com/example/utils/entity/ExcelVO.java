package com.example.utils.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Cc
 * @Date: 2021/5/31 17:04
 */
@Data
public class ExcelVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 仓单号（能源中心非原油品种/上期所/郑商所非通用品种）
     * 仓库（能源中心原油品种/大商所）
     * 等级/类别（郑商所通用品种）
     */
    private String receiptNumber;
    /**
     * 油种（仅能源中心油品品种时使用该字段）
     */
    private String oilType;
    /**
     * 转让数量(张)
     */
    private String transferNum;
    /**
     * 转让价格（委托方式为自行结算时无该字段）
     */
    private String transferPrice;
    /**
     * 重量
     */
    private String weight;
    /**
     * 货款（委托方式为自行结算时无该字段）
     */
    private String price;
}
