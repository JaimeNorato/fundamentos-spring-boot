package com.findamentosplatzi.springboot.fundamentos.configuration;

import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitProperties;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitPropertiesImplement;
import com.findamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${driver}")
    private String driver;

    @Bean
    public MyBeanWhitProperties function() {
        return new MyBeanWhitPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
