package com.findamentosplatzi.springboot.fundamentos.caseuse;

import com.findamentosplatzi.springboot.fundamentos.entity.User;
import com.findamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public User save(User newUser) {
       return userService.save(newUser);
    }
}
