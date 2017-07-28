package com.training.spring;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class AsyncTest {

    // Aynı objede çağrılırsa çalışmıyor!!
    @Async("myExecuter")
    public Future<String> testAsync() {
        System.out.println("Running Async test : " + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("test");
    }

}
