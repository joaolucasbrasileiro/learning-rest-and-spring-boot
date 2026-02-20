package com.lucasbrasileiro.service;

import com.lucasbrasileiro.exception.ResourceNotFoundException;
import com.lucasbrasileiro.model.User;
import com.lucasbrasileiro.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    UserRepository userRepository;


    public List<User> findAll() {
        logger.info("Find All Users");
        return userRepository.findAll();
    }

    public User findById(Long id) {
        logger.info("Find User by ID {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));
    }

    public User create(User user) {
        logger.info("Create User {}", user);
       return userRepository.save(user);
    }

    public void delete (Long id) {
        logger.info("Delete User {}", id);
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));
        userRepository.delete(entity);
    }

    public User update (User user) {
        logger.info("Update User {}", user);
        User entity = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));

        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        return userRepository.save(entity);
    }
}
