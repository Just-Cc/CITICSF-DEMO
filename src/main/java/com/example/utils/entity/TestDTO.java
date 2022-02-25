package com.example.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author: Cc
 * @Date: 2021/8/27 13:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO implements Cloneable{

    @NotBlank
    @Size(max = 20)
    private String text;

    @NotBlank
    private String mark;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
