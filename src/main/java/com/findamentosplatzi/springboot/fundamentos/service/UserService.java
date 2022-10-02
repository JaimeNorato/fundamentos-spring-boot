package com.findamentosplatzi.springboot.fundamentos.service;

import com.findamentosplatzi.springboot.fundamentos.entity.User;
import com.findamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
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

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public boolean delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User update(User user, Long id) {
        User userDB = userRepository.findById(id).orElse(null);
        if (userDB != null) {
            userDB.setName(user.getName());
            userDB.setEmail(user.getEmail());
            userDB.setBirthDate(user.getBirthDate());
            return userRepository.save(userDB);
        }
        return null;
    }

    public List<User> paginate(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
