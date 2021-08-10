package com.example.utils.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author: Cc
 * @Date: 2021/8/10 10:21
 */
@Controller
@RequestMapping("free")
public class LoginController {

    @GetMapping("login")
    public String login(ModelMap map){
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        map.put("4","四");
        map.put("5","五");
        map.put("title","这是标题");
        return "index";
    }
}
