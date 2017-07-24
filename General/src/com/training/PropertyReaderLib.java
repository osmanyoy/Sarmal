package com.training;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by Osman on 24.07.2017.
 */
public class PropertyReaderLib<T> {

    public T fillObject(Class<T> classT) throws Exception{
        T obj = classT.newInstance();
        PropertySource propertySource = classT.getAnnotation(PropertySource.class);
        if (propertySource != null){
            File file = new File(propertySource.fileName());

            Properties properties = new Properties();
            properties.load(new FileInputStream(file));

            Field[] declaredFields = classT.getDeclaredFields();
            for (Field field: declaredFields
                 ) {
                PropertyItem propertyItem = field.getAnnotation(PropertyItem.class);
                if (propertyItem != null){
                    String key = propertyItem.key();
                    String property = properties.getProperty(key);
                    Class<?> type = field.getType();
                    if (type.getName().equals("java.util.String")){
                        field.set(obj,property);
                    } else if (type.getName().equals("int")){
                        field.set(obj,Integer.parseInt(property));
                    } else if (type.getName().equals("long")){
                        field.set(obj,Long.parseLong(property));
                    }
                }

            }
        }
        return obj;
    }
}
