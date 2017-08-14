package com.training.spring.springadv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Component
public class MyCondition implements Condition {


    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        MultiValueMap<String, Object> myContionAnno = annotatedTypeMetadata.getAllAnnotationAttributes(MyConditionAnno.class.getName());
        List<Object> name = myContionAnno.get("name");
        Integer intI = (Integer)myContionAnno.getFirst("intVal");
        return true;
    }
}
