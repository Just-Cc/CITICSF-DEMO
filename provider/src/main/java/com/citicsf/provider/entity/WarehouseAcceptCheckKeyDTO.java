package com.citicsf.provider.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarehouseAcceptCheckKeyDTO {
    @JsonProperty("acpt_id")
    private String acptId;

    @JsonProperty("check_item")
    private String checkItem;
}