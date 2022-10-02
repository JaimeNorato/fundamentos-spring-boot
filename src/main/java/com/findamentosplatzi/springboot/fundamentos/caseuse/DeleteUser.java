package com.findamentosplatzi.springboot.fundamentos.caseuse;

import com.findamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public boolean delete(Long id) {
        return userService.delete(id);
    }
}
