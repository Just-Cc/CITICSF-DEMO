package com.example.utils;


import com.example.utils.entity.TestDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * @Author: Cc
 * @Date: 2021/6/3 15:38
 */

public class Test {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toString());

    }

    public static void lambdaTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("5");
        list.add("5");
        list.add("7");
        long startTime = System.currentTimeMillis();
        //list.stream().distinct().forEach(System.out::println);
        //list.stream().sorted().filter(s -> Integer.valueOf(s) < 5).forEach(System.out::println);
        list.stream().map(s -> Integer.valueOf(s)*5).forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        long spendTime = endTime - startTime;
        System.out.println("spend time : "+spendTime/1000 + "s");
    }

    public static void stringTest(){
        long storage = 10831;
        long startTime = System.currentTimeMillis();
        //String s = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
           builder.append("买方将产生仓储费"+storage+"元/天");
        }
        long endTime = System.currentTimeMillis();
        long spendTime = endTime - startTime;
        System.out.println("spend time : "+spendTime + "ms");
    }
}
