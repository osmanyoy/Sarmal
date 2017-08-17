package com.training.integration.springintegrationtraining;

import java.util.concurrent.atomic.AtomicLong;

public class MyThread1 extends Thread{
    public static AtomicLong counter = new AtomicLong();

//    public static synchronized void increase(){
//        counter++;
//    }
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            counter.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
        }

        try {
            Thread.sleep(10_000);
        }catch (Exception ex){

        }

        System.out.println(counter);
    }
}
