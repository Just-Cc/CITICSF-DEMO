package com.example.utils.entity;

import java.time.LocalDateTime;

public class WarehouseTransferInfo {
    private Long id;

    private Long warehouseTransferId;

    private String receiptNumber;

    private String oilType;

    private String transferNum;

    private String transferPrice;

    private String weight;

    private String price;

    private String transferNumTotal;

    private String weightTotal;

    private String priceTotal;

    private String storageCharges;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public WarehouseTransferInfo(Long id, Long warehouseTransferId, String receiptNumber, String oilType, String transferNum, String transferPrice, String weight, String price, String transferNumTotal, String weightTotal, String priceTotal, String storageCharges, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.warehouseTransferId = warehouseTransferId;
        this.receiptNumber = receiptNumber;
        this.oilType = oilType;
        this.transferNum = transferNum;
        this.transferPrice = transferPrice;
        this.weight = weight;
        this.price = price;
        this.transferNumTotal = transferNumTotal;
        this.weightTotal = weightTotal;
        this.priceTotal = priceTotal;
        this.storageCharges = storageCharges;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public WarehouseTransferInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseTransferId() {
        return warehouseTransferId;
    }

    public void setWarehouseTransferId(Long warehouseTransferId) {
        this.warehouseTransferId = warehouseTransferId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber == null ? null : receiptNumber.trim();
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType == null ? null : oilType.trim();
    }

    public String getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(String transferNum) {
        this.transferNum = transferNum == null ? null : transferNum.trim();
    }

    public String getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(String transferPrice) {
        this.transferPrice = transferPrice == null ? null : transferPrice.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTransferNumTotal() {
        return transferNumTotal;
    }

    public void setTransferNumTotal(String transferNumTotal) {
        this.transferNumTotal = transferNumTotal == null ? null : transferNumTotal.trim();
    }

    public String getWeightTotal() {
        return weightTotal;
    }

    public void setWeightTotal(String weightTotal) {
        this.weightTotal = weightTotal == null ? null : weightTotal.trim();
    }

    public String getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(String priceTotal) {
        this.priceTotal = priceTotal == null ? null : priceTotal.trim();
    }

    public String getStorageCharges() {
        return storageCharges;
    }

    public void setStorageCharges(String storageCharges) {
        this.storageCharges = storageCharges == null ? null : storageCharges.trim();
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
        sb.append(", warehouseTransferId=").append(warehouseTransferId);
        sb.append(", receiptNumber=").append(receiptNumber);
        sb.append(", oilType=").append(oilType);
        sb.append(", transferNum=").append(transferNum);
        sb.append(", transferPrice=").append(transferPrice);
        sb.append(", weight=").append(weight);
        sb.append(", price=").append(price);
        sb.append(", transferNumTotal=").append(transferNumTotal);
        sb.append(", weightTotal=").append(weightTotal);
        sb.append(", priceTotal=").append(priceTotal);
        sb.append(", storageCharges=").append(storageCharges);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}