package com.findamentosplatzi.springboot.fundamentos.configuration;

import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitProperties;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWhitProperties function() {
        return new MyBeanWhitPropertiesImplement(name, apellido);
    }
}
