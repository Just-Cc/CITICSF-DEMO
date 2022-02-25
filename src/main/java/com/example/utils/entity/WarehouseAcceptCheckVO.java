package com.example.utils.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarehouseAcceptCheckVO {
    private String businessId;

    private String checkItem;

    private String acptId;

    /**
     * 0-通过 1-不通过
     */
    private String acceptResult;

    private String acceptDetail;

    private String acceptDescription;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}