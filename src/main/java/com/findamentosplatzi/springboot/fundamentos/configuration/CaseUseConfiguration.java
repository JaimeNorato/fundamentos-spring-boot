package com.findamentosplatzi.springboot.fundamentos.configuration;

import com.findamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.findamentosplatzi.springboot.fundamentos.caseuse.GetUserImplement;
import com.findamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
