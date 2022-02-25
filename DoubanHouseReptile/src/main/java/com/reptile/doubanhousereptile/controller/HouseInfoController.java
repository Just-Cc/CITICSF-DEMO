package com.reptile.doubanhousereptile.controller;

import com.reptile.doubanhousereptile.service.HouseReptile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Cc
 * @Date: 2021/12/8 10:11
 */
@RestController
@RequestMapping("houseInfo")
public class HouseInfoController {

    @Autowired
    private HouseReptile houseReptile;

    @GetMapping("reptile")
    public void getHouseInfo(HttpServletResponse response) {
        houseReptile.getInfo(response);
    }
}
