package com.example.utils.controller;

import com.example.utils.entity.TestDTO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: Cc
 * @Date: 2021/9/14 15:45
 */
@RestController
@RequestMapping("test")
@Validated
public class TestController {

    @PostMapping("length")
    public void lengthTest(@Valid @RequestBody TestDTO testDTO){
        System.out.println(testDTO.getText().length());
    }


    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
            produces = {MediaType.ALL_VALUE})
    public void testRequest(){
        System.out.println("进来了");
    }
}
