package com.patters;

/**
 * Created by Osman on 9.08.2017.
 */
public class Test {
    public static void main(String[] args) {
        Singleton.getInstance();

        SingletonEager.INSTANCE1.helloWorld();
    }
}
