package com.example.config;

import com.example.config.DispatcherServerConfig;
import com.example.config.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServerConfig.class, TomcatWebServerConfig.class})
public @interface EnableMyAutoConfiguration {
}
