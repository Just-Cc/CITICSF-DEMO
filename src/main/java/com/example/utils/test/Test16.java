package com.example.utils.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Cc
 * @Date: 2022/2/23 16:43
 */
public class Test16 {
    /**
     * 用面向对象的方法打印出数组中各个元素出现几次
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 1;
        for (int i : arr) {
            Integer integer = hashMap.get(i);
            if(null != integer){
                count = integer + 1;
            }
            hashMap.put(i, count);
            count = 1;
        }
        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次");
        }
    }
}
