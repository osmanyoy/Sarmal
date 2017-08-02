package com.example.demo;

import org.springframework.boot.actuate.metrics.Metric;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Osman on 1.08.2017.
 */
public class MyMetric extends Metric<Long> {
    private AtomicLong atomicLong = new AtomicLong();

    public MyMetric(String name,
                    Long value) {
        super(name,
              value);
    }

    @Override
    public Long getValue() {
        return atomicLong.get();
    }

    @Override
    public Metric<Long> increment(int amount) {
        atomicLong.addAndGet(amount);
        return this;
    }
}
