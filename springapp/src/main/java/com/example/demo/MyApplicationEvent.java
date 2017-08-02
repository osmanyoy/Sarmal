package com.example.demo;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Osman on 1.08.2017.
 */
public class MyApplicationEvent extends ApplicationEvent{

    private String desc;

    public MyApplicationEvent() {
        super(MyApplicationEvent.class);
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
