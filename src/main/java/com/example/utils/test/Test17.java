package com.example.utils.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @Author: Cc
 * @Date: 2022/2/23 17:36
 */
@Slf4j
public class Test17 {
    /**
     * 多线程demo
     * 1.继承了Thread类的 调用Thread类中的start方法
     * 2.实现Runnable接口的，调用重写后的run方法
     * 3.实现Callable接口的，调用重写后的call方法
     * @param args
     */
    public static void main(String[] args) throws Exception {
        new Threads1().start();
        new Threads2().run();
        new Threads3().call();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor();
        poolExecutor.setRejectedExecutionHandler();
        RejectedExecutionHandler rejectedExecutionHandler = poolExecutor.getRejectedExecutionHandler();
    }

    @Slf4j
    public static class Threads1 extends Thread{

        @SneakyThrows
        @Override
        public void run(){
            while (true){
                log.info("Threads1类正在睡觉");
                Thread.sleep(2000);
                log.info("睡了两秒，睡醒了");
            }
        }
    }

    @Slf4j
    public static class Threads2 implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            while (true){
                log.info("Threads2类正在睡觉");
                Thread.sleep(3000);
                log.info("睡了三秒，睡醒了");
            }
        }
    }

    @Slf4j
    public static class Threads3 implements Callable {

        @SneakyThrows
        @Override
        public Object call(){
            while (true){
                log.info("Threads3类正在睡觉");
                Thread.sleep(4000);
                log.info("睡了四秒，睡醒了");
            }
        }
    }
}
