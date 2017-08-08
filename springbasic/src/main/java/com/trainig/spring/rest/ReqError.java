package com.trainig.spring.rest;

/**
 * Created by Osman on 8.08.2017.
 */
public class ReqError {
    private int cause;
    private String desc;

    public int getCause() {
        return cause;
    }

    public void setCause(int cause) {
        this.cause = cause;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
