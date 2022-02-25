package com.example.utils.test;

/**
 * @Author: Cc
 * @Date: 2021/11/15 15:30
 */
public class Test6{
    public static int a = 0;
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("a: " + a);
                    a++;
                }
            }).start();
        }

    }
}
