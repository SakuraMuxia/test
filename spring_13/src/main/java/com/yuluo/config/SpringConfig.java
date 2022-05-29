package com.yuluo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.yuluo")
@PropertySource("{jdbc.properties}")
public class SpringConfig {

}
