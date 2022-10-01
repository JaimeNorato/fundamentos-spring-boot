package com.findamentosplatzi.springboot.fundamentos.service;

import com.findamentosplatzi.springboot.fundamentos.entity.User;
import com.findamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuario a insertar: " + user))
                .forEach(userRepository::save);
//        throw new RuntimeException("Esta es una excepcion lanzada intencionalmente");
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
