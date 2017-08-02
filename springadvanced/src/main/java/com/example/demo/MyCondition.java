package com.example.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {

        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(MyConditionalAnno.class.getName());
        Integer port = (Integer)annotationAttributes.get("port");
        String testStr = (String)annotationAttributes.get("test");

        if (port== 8080){
            return true;
        }
        String property = System.getProperty("test.conditional");
        if (property != null && property.equals(testStr)){
            return true;
        }
        return false;
    }

}
