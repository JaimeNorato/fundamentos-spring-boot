package com.findamentosplatzi.springboot.fundamentos.configuration;

import com.findamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
