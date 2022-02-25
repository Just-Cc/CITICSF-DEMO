package com.citicsf.provider.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseAcceptCheckDTO extends WarehouseAcceptCheckKeyDTO {
    @JsonProperty("accept_result")
    private String acceptResult;

    @JsonProperty("accept_detail")
    private String acceptDetail;

    @JsonProperty("accept_description")
    private String acceptDescription;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}