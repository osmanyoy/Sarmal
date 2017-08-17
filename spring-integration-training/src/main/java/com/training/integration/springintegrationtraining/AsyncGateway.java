package com.training.integration.springintegrationtraining;

import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;

public interface AsyncGateway {
    ListenableFuture<String> start(Person person);
}
