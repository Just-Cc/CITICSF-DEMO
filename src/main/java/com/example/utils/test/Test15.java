package com.example.utils.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * @Author: Cc
 * @Date: 2022/2/23 11:24
 */
public class Test15 {
    /**
     * 不拆开键值对的情况下，根据User的age字段对HashMap中的元素进行排序
     * @param args
     */
    public static void main(String[] args) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        hashMap.put(1, new User("张三",24));
        hashMap.put(3, new User("李四",18));
        hashMap.put(2, new User("王五",35));

        HashMap<Integer, User> map = sortedHashMap(hashMap);
        System.out.println(map);

    }


    @Data
    @AllArgsConstructor
    public static class User{
        private String name;
        private int age;
    }

    public static HashMap<Integer,User> sortedHashMap(HashMap<Integer,User> hashMap){
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        list.sort(Comparator.comparingInt(o -> o.getValue().getAge()));

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
