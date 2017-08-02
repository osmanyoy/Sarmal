package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class MyConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setEnabled(true);
        List<String> urls = new ArrayList<>();
        urls.add("/hello");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }

    @Bean
    public Executor executor() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(executor());
        return simpleApplicationEventMulticaster;
    }
}

