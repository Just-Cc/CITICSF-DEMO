package com.example.utils.entity;

import java.time.LocalDateTime;

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

    private String downPaymentPercent;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public WarehouseTransfer(Long id, String fundAccount, String customerName, String tradingSystemType, String exchangeCode, String varietyCode, String subAcct, String transactionCode, String transferType, String transferNumber, String otherTransactionCode, String otherClientName, String otherFuturesCompany, String warehouseReceiptType, String settleEntrustMethod, String downPaymentPercent, String status, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.fundAccount = fundAccount;
        this.customerName = customerName;
        this.tradingSystemType = tradingSystemType;
        this.exchangeCode = exchangeCode;
        this.varietyCode = varietyCode;
        this.subAcct = subAcct;
        this.transactionCode = transactionCode;
        this.transferType = transferType;
        this.transferNumber = transferNumber;
        this.otherTransactionCode = otherTransactionCode;
        this.otherClientName = otherClientName;
        this.otherFuturesCompany = otherFuturesCompany;
        this.warehouseReceiptType = warehouseReceiptType;
        this.settleEntrustMethod = settleEntrustMethod;
        this.downPaymentPercent = downPaymentPercent;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public WarehouseTransfer() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount == null ? null : fundAccount.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getTradingSystemType() {
        return tradingSystemType;
    }

    public void setTradingSystemType(String tradingSystemType) {
        this.tradingSystemType = tradingSystemType == null ? null : tradingSystemType.trim();
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode == null ? null : exchangeCode.trim();
    }

    public String getVarietyCode() {
        return varietyCode;
    }

    public void setVarietyCode(String varietyCode) {
        this.varietyCode = varietyCode == null ? null : varietyCode.trim();
    }

    public String getSubAcct() {
        return subAcct;
    }

    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct == null ? null : subAcct.trim();
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode == null ? null : transactionCode.trim();
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType == null ? null : transferType.trim();
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber == null ? null : transferNumber.trim();
    }

    public String getOtherTransactionCode() {
        return otherTransactionCode;
    }

    public void setOtherTransactionCode(String otherTransactionCode) {
        this.otherTransactionCode = otherTransactionCode == null ? null : otherTransactionCode.trim();
    }

    public String getOtherClientName() {
        return otherClientName;
    }

    public void setOtherClientName(String otherClientName) {
        this.otherClientName = otherClientName == null ? null : otherClientName.trim();
    }

    public String getOtherFuturesCompany() {
        return otherFuturesCompany;
    }

    public void setOtherFuturesCompany(String otherFuturesCompany) {
        this.otherFuturesCompany = otherFuturesCompany == null ? null : otherFuturesCompany.trim();
    }

    public String getWarehouseReceiptType() {
        return warehouseReceiptType;
    }

    public void setWarehouseReceiptType(String warehouseReceiptType) {
        this.warehouseReceiptType = warehouseReceiptType == null ? null : warehouseReceiptType.trim();
    }

    public String getSettleEntrustMethod() {
        return settleEntrustMethod;
    }

    public void setSettleEntrustMethod(String settleEntrustMethod) {
        this.settleEntrustMethod = settleEntrustMethod == null ? null : settleEntrustMethod.trim();
    }

    public String getDownPaymentPercent() {
        return downPaymentPercent;
    }

    public void setDownPaymentPercent(String downPaymentPercent) {
        this.downPaymentPercent = downPaymentPercent == null ? null : downPaymentPercent.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fundAccount=").append(fundAccount);
        sb.append(", customerName=").append(customerName);
        sb.append(", tradingSystemType=").append(tradingSystemType);
        sb.append(", exchangeCode=").append(exchangeCode);
        sb.append(", varietyCode=").append(varietyCode);
        sb.append(", subAcct=").append(subAcct);
        sb.append(", transactionCode=").append(transactionCode);
        sb.append(", transferType=").append(transferType);
        sb.append(", transferNumber=").append(transferNumber);
        sb.append(", otherTransactionCode=").append(otherTransactionCode);
        sb.append(", otherClientName=").append(otherClientName);
        sb.append(", otherFuturesCompany=").append(otherFuturesCompany);
        sb.append(", warehouseReceiptType=").append(warehouseReceiptType);
        sb.append(", settleEntrustMethod=").append(settleEntrustMethod);
        sb.append(", downPaymentPercent=").append(downPaymentPercent);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}