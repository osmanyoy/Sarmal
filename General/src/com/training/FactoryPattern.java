package com.training;

import com.training.impl.MyInterfaceImpl1;
import com.training.impl.MyInterfaceImpl2;
import com.training.impl.MyInterfaceImpl3;

/**
 * Created by Osman on 24.07.2017.
 */
public class FactoryPattern {
    public  static IMyInterface getImpl(int i){
        switch (i){
            case 0:
                return new MyInterfaceImpl1();
            case 1:
                return new MyInterfaceImpl2();
            case 2:
                return new MyInterfaceImpl3();
            default:
                return  null;
        }
    }
}
