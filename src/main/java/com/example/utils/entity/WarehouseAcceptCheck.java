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
public class WarehouseAcceptCheck extends WarehouseAcceptCheckKey {

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