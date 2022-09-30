package com.findamentosplatzi.springboot.fundamentos.configuration;

import com.findamentosplatzi.springboot.fundamentos.bean.*;
import com.findamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWhitDependency beanOperationOperationWhitDependency(MyOperation myOperation) {
        return new MyBeanWhitDependencyImplement(myOperation);
    }
}
