package com.training;

import com.training.impl.MyInterfaceImpl1;
import com.training.impl.MyInterfaceImpl2;
import com.training.impl.MyInterfaceImpl3;

import java.lang.reflect.Field;

/**
 * Created by Osman on 24.07.2017.
 */
public class AnnotionSample {

    public static void main(String[] args) throws Exception{
        Class<Main> mainClass = Main.class;
        Field[] declaredFields = mainClass.getDeclaredFields();
        for (Field field:declaredFields) {
            Koy annotation = field.getAnnotation(Koy.class);
            if(annotation != null){
                int version = annotation.version();
                Object obj = mainClass.newInstance();
                IMyInterface myInterface = null;
                switch (version){
                    case 1:
                        myInterface = new MyInterfaceImpl1();
                    case 2:
                        myInterface = new MyInterfaceImpl2();
                    case 3:
                        myInterface = new MyInterfaceImpl3();
                }
                field.setAccessible(true);
                field.set(obj,myInterface);
            }


        }
    }
}
