package com.trainig.spring;

import com.trainig.spring.myimpl.IMyInterface;
import com.trainig.spring.myimpl.MyInterfaceImpl1;
import com.trainig.spring.myimpl.MyInterfaceImpl2;
import com.trainig.spring.myimpl.MyInterfaceImpl3;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.trainig.OrgConfig;
import org.trainig.TestAppRun;

@Configuration
@Import(OrgConfig.class)
public class AppConfig {

    @Bean
    @Primary
    // @Scope("prototype")
    public AppProp osmanyaratti(){
        AppProp appProp = new AppProp();
        appProp.setServerName("osmanyarrati");
        return appProp;
    }

    @Bean("nevam")
    @Qualifier("mevam")
    // @Primary
    // @Scope("prototype")
    public AppProp devam(){
        AppProp appProp = new AppProp();
        appProp.setServerName("devam");
        return appProp;
    }

    @Bean
    @Coz
    // @Primary
    // @Scope("prototype")
    public AppProp test(){
        AppProp appProp = new AppProp();
        appProp.setServerName("test");
        return appProp;
    }

    @Bean
    public IMyInterface myInterface1(){
        return new MyInterfaceImpl1();
    }

    @Bean
    public IMyInterface myInterface2(){
        return new MyInterfaceImpl2();
    }
    @Bean
    public IMyInterface myInterface3(){
        return new MyInterfaceImpl3();
    }

}
