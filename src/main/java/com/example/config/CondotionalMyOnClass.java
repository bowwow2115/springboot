package com.example.config;

import org.springframework.context.annotation.Conditional;

import javax.websocket.OnClose;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(MyOnClassCondition.class)
public @interface CondotionalMyOnClass {
    String value();
}
