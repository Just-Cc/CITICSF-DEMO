package com.example.utils.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: Cc
 * @Date: 2021/6/30 10:33
 */
@Data
public class CancellationApplyExcelDTO {
    private List<CancellationExcelDTO> cancellationExcelInfo;

    private String exchangeCode;

    private String prodCode;

    private String cancelCount;

    private String storageCharges;
}
