package com.training.spring.springadv;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cihaz")
// @Scope("prototype")
public class Device implements InitializingBean,BeanNameAware,BeanClassLoaderAware {
    private String name;
    private String location;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }
}
