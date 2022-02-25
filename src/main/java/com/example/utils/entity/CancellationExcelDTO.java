package com.example.utils.entity;

import lombok.Data;

/**
 * @Author: Cc
 * @Date: 2021/6/30 10:34
 */
@Data
public class CancellationExcelDTO {
    /**
     * 仓单号（郑商所非通用品种）
     */
    private String warehouseReceiptNo;
    /**
     * 仓单号（大商所）
     */
    private String warehouseBranch;
    /**
     * 仓库及编号（郑商所通用品种）
     */
    private String warehouseNo;
    /**
     * 仓单类型
     */
    private String warehouseType;
    /**
     * 其他
     */
    private String other;
    /**
     * 注销数量(张)
     */
    private String cancelNumber;
    /**
     * 提货库区(仅大商所玉米C品种使用该字段)
     */
    private String pickUpArea;
}
