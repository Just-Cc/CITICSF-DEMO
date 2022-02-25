package com.example.utils.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2021/5/31 16:57
 */
@Data
public class ApplyExcelVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ExcelVO> excelInfo;

    private String exchangeCode;

    private String prodCode;

    private String settlementEntrust;
}
