package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Scope("singleton")
@Component
public class Device implements BeanFactoryAware{
    private long id;
    private String name;
    private long startTime;
    private EDeviceType type;

    public void myInit(){
        System.out.println("Yaratıldım");
    }

    public void destroy(){
        System.out.println("Öldüm");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public EDeviceType getType() {
        return type;
    }

    public void setType(EDeviceType type) {
        this.type = type;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
