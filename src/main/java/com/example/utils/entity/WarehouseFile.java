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
public class WarehouseFile extends WarehouseFileKey {
    private String acptId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}