package com.training.integration.springintegrationtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.channel.PublishSubscribeChannel;

public class ComLinRunner implements CommandLineRunner{
    @Autowired
    private PublishSubscribeChannel publishSubscribeChannel;

    @Override
    public void run(String... strings) throws
                                       Exception {

    }
}
