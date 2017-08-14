package com.training.spring.springadv;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

// @Component
public class DeviceFactory implements FactoryBean<Device> {
    @Override
    public Device getObject() throws Exception {
        Device device = new Device();
        device.setName("Defualt");
        return device;
    }

    @Override
    public Class<?> getObjectType() {
        return Device.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
