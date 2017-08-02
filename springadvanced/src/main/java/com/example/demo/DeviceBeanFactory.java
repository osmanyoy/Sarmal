package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by Osman on 31.07.2017.
 */
public class DeviceBeanFactory extends AbstractFactoryBean<Device>{
    @Override
    public Class<?> getObjectType() {
        return Device.class;
    }

    @Override
    protected Device createInstance() throws Exception {
        return new Device();
    }
}
