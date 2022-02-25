package com.example.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseReceiptCancel {
    private Long id;

    private String missionCode;

    private String acptId;

    private String status;

    private String fundAccount;

    private String customerName;

    private String tradingSystemType;

    private String exchangeCode;

    private String varietyCode;

    private String subAcct;

    private String transactionCode;

    private String cancelCount;

    private String hands;

    private String productPlace;

    private String packaging;

    private String storageCharges;

    private Integer blackWhiteFlag;

    private String consigneeName;

    private String consigneeIdNo;

    private String consigneePhone;

    private String consigneePasswordSet;

    private String consigneePassword;

    private String operationId;

    private String customerType;

    private String tradingCodeName;

    private String businessName;

    private String approvalOpinion;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}