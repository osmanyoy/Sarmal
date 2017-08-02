package com.example.demo;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PublicSayicilar implements PublicMetrics{

    private List<Metric<?>> myMetrics;
    public PublicSayicilar(){
        myMetrics = new ArrayList<>();
        myMetrics.add(new MyMetric("osman1",0L));
        myMetrics.add(new MyMetric("osman2",0L));
        myMetrics.add(new MyMetric("osman3",0L));
        myMetrics.add(new MyMetric("osman4",0L));
    }

    @Override
    public Collection<Metric<?>> metrics() {
        return myMetrics;
    }
}
