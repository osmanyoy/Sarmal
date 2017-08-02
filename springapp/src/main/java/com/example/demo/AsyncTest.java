package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncTest {

    @Async("executor")
    public ListenableFuture<String> test() {
        try {
            Thread.sleep(10_000);
        }
        catch (Exception ex) {
            ex.getMessage();
        }
        return new AsyncResult<>("test dönüşü");
    }

    @Async("executor")
    public CompletableFuture<String> testCompletable() {
        try {
            Thread.sleep(10_000);
        }
        catch (Exception ex) {
            ex.getMessage();
        }
        return CompletableFuture.completedFuture("test return");
    }

    @Scheduled(fixedDelay = 10_000 ,initialDelay = 10_000)
    public void scheduleTest(){
        System.out.println("Schedule test");
    }

}
