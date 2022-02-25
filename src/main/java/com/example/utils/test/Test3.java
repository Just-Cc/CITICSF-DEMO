package com.example.utils.test;

import com.citicsf.common.core.util.crypto.CryptoSMUtils;

/**
 * @Author: Cc
 * @Date: 2021/8/16 13:57
 */
public class Test3 {
    public static void main(String[] args) {
        String password = "29c67a30398638269fe600f73a054934";
        String salt = "111111";

        String s = CryptoSMUtils.sm4DecCbc(salt, password);
        System.out.println(s);
    }
}
