package com.lucasbrasileiro.service;


import com.lucasbrasileiro.data.dto.v1.UserDTO;
import com.lucasbrasileiro.exception.ResourceNotFoundException;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseListObjects;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseObject;

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


    public List<UserDTO> findAll() {
        logger.info("Find All Users");
        return parseListObjects(userRepository.findAll(),  UserDTO.class);
    }

    public UserDTO findById(Long id) {
        logger.info("Find User by ID {}", id);
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));
        return parseObject(entity, UserDTO.class);
    }

    public UserDTO create(UserDTO user) {
        logger.info("Create User {}", user);
        var entity = parseObject(user, User.class);

        return parseObject(userRepository.save(entity), UserDTO.class);
    }

    public void delete (Long id) {
        logger.info("Delete User {}", id);
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));
        userRepository.delete(entity);
    }

    public UserDTO update (UserDTO user) {
        logger.info("Update User {}", user);
        User entity = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));

        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());

        return parseObject(userRepository.save(entity), UserDTO.class);
    }
}
