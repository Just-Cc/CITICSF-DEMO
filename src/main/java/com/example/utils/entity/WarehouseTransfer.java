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
public class WarehouseTransfer {
    private Long id;

    private String fundAccount;

    private String customerName;

    private String tradingSystemType;

    private String exchangeCode;

    private String varietyCode;

    private String subAcct;

    private String transactionCode;

    private String transferType;

    private String transferNumber;

    private String otherTransactionCode;

    private String otherClientName;

    private String otherFuturesCompany;

    private String warehouseReceiptType;

    private String settleEntrustMethod;

    /**
     * 首付款比例 0 ‘80%’，1 ‘100%’
     */
    private String downPaymentPercent;

    /**
     * 状态 0-暂存，1-办理中，2-办理成功，3-办理失败，4-审核驳回，5-作废
     */
    private String status;

    private String missionCode;

    private String transferNumTotal;

    private String weightTotal;

    private String priceTotal;

    private String storageCharges;

    private String hands;

    private String businessName;

    private String approvalOpinion;

    private String operationId;

    /**
     * 对方客户黑名单标识 0-正常，1-疑似，2-黑名单用户
     */
    private Integer sellerBlackWhiteFlag;

    /**
     * 本人黑名单标识 0-正常，1-疑似，2-黑名单用户
     */
    private Integer buyerBlackWhiteFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String acptId;

    private String customerType;

    private String tradingCodeName;
}