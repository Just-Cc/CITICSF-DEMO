package com.example.utils.test;

import com.example.utils.entity.ApplyExcel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cc
 * @Date: 2021/8/11 16:11
 */
@RestController
@RequestMapping("testt")
public class Test2 {

    @GetMapping("ggg")
    public ApplyExcel ggg(){
        ApplyExcel applyExcel = new ApplyExcel();
        applyExcel.setPrice("123123");
        return applyExcel;
    }
}
