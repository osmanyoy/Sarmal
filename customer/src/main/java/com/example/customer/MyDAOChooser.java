package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyDAOChooser {

    @Autowired
    private ApplicationContext applicationContext;

    public EDAOType chooseDAOType(){
        String[] activeProfiles = applicationContext.getEnvironment()
                                                    .getActiveProfiles();
        for (String profile:
             activeProfiles) {
            if (activeProfiles.equals("live")){
                return EDAOType.DB;
            }
        }
        return EDAOType.FILE;
    }
}
