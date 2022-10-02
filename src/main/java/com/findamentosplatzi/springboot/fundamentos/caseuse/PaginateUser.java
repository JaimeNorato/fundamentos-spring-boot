package com.findamentosplatzi.springboot.fundamentos.caseuse;

import com.findamentosplatzi.springboot.fundamentos.entity.User;
import com.findamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaginateUser {
    private UserService userService;

    public PaginateUser(UserService userService) {
        this.userService = userService;
    }

    public List<User> paginate(int page, int size) {
        return userService.paginate(page, size);
    }
}
