package com.patters;

/**
 * Created by Osman on 9.08.2017.
 */
public enum SingletonEager {
    INSTANCE1("instance1");

    private String helloString;

    SingletonEager(String instance1) {
        helloString = instance1;
    }

    public String helloWorld(){
        return helloString;
    }

    public void setHelloString(String helloString) {
        this.helloString = helloString;
    }

    public String getHelloString() {
        return helloString;
    }
}
