package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@Profile("live")
@PropertySource("classpath:my.properties")
@EnableConfigurationProperties
public class SAConfiguration {

    @Bean({"device1","device2"})
    @Scope("prototype")
    public Device deviceCreate(){
        return new Device();
    }

    @Bean
    public BeanPostPro beanPostPro(){
        return new BeanPostPro();
    }

    @Bean
    @MyConditionalAnno(port = 8080,test = "test properties")
    public Device testConditional(){
        return new Device();
    }

    @Bean
    public Device testConditional2(){
        return new Device();
    }

    @Bean
    public DeviceBeanFactory deviceBeanFactory(){
        return new DeviceBeanFactory();
    }

    public Properties properties(){
        return new Properties();
    }

    @Bean
    public Device deviceMethod1(){
        return new Device();
    }

    @Bean
    public Device deviceMethod10(@Value("${my.device.index}") int index){
        Device device = new Device();
        switch (index){
            case 1:
                device.setType(EDeviceType.PICO);
                break;
            case 2:
                device.setName("Test");
            case 3:
                device.setType(EDeviceType.NANO);
        }
        return device;
    }

    @Bean(initMethod = "myInit",destroyMethod = "destroy")
    @Qualifier("ahmet")
    public Device deviceMethod2(){
        return new Device();
    }

    @Bean
    @Mehmet
    public Device deviceMethod3(){
        return new Device();
    }

}
