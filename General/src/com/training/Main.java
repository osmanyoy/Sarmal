package com.training;


public class Main {

    @Koy(version = 2)
    private IMyInterface myInterface;

    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        IMyInterface iMyInterface = FactoryPattern.getImpl(i);

    }
}
