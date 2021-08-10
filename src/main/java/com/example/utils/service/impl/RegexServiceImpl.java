package com.example.utils.service.impl;

import com.example.utils.service.RegexService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Cc
 * @Date: 2021/6/24 14:26
 */
public class RegexServiceImpl implements RegexService {
    @Override
    public boolean checkPhoneNumber(String phoneNum) {
        String phoneRegex11 = "^1[0-9]{10}$";
        String phoneRegexAll = "^1[3|4|5|7|8][0-9]{9}$";
        Pattern pattern = Pattern.compile(phoneRegexAll);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    @Override
    public boolean checkIdCard(String idCard) {
        String idCardRegex15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$";
        String idCardRegex18 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        if(idCard.length() == 15){
            Pattern pattern = Pattern.compile(idCardRegex15);
            Matcher matcher = pattern.matcher(idCard);
            return matcher.matches();
        }else if(idCard.length() == 18){
            Pattern pattern = Pattern.compile(idCardRegex18);
            Matcher matcher = pattern.matcher(idCard);
            return matcher.matches();
        }else {
            System.out.println("证件号码长度有误");
            return false;
        }
    }
}
