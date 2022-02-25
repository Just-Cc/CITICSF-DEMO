package com.example.utils.test;

import com.citicsf.common.core.util.gson.GsonUtils;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Cc
 * @Date: 2021/12/1 16:54
 */
public class Test11 {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a","a");
        treeMap.put("b","b");
        treeMap.put("c","c");
        treeMap.put("d","d");
        System.out.println("treeMap : "+GsonUtils.toJsonString(treeMap));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a","a");
        hashMap.put("b","b");
        hashMap.put("c","c");
        hashMap.put("d","d");
        System.out.println("hashMap : "+GsonUtils.toJsonString(treeMap));

        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
    }
}
