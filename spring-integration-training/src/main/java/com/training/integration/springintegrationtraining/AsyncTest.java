package com.training.integration.springintegrationtraining;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class AsyncTest {

    @Async("executor")
    public Future<String> callMe(){
        try {
            Thread.sleep(2_000);
        }catch (Exception ex){

        }
        return CompletableFuture.completedFuture("Ben tamamlandım");
    }

    @Async("executor")
    public ListenableFuture<String> callMeListen(){
        try {
            Thread.sleep(2_000);
        }catch (Exception ex){

        }
        return AsyncResult.forValue("Ben tamamlandım");
    }

}
