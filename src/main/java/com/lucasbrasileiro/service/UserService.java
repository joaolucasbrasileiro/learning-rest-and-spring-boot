package com.lucasbrasileiro.service;


import com.lucasbrasileiro.controller.UserController;
import com.lucasbrasileiro.data.dto.v1.UserDTO;
import com.lucasbrasileiro.exception.ResourceNotFoundException;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseListObjects;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseObject;

import com.lucasbrasileiro.model.User;
import com.lucasbrasileiro.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    UserRepository userRepository;


    public List<UserDTO> findAll() {
        logger.info("Find All Users");
        var users = parseListObjects(userRepository.findAll(),  UserDTO.class);

        users.forEach(this::addHateoasLinks);
        return users;
    }

    public UserDTO findById(Long id) {
        logger.info("Find User by ID {}", id);
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User não encontrado!"));
        var dto = parseObject(entity, UserDTO.class);

        addHateoasLinks(dto);

        return dto;
    }

    public UserDTO create(UserDTO user) {
        logger.info("Create User {}", user);
        var entity = parseObject(user, User.class);

        var dto = parseObject(userRepository.save(entity), UserDTO.class);
        addHateoasLinks(dto);

        return dto;
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

        var dto = parseObject(userRepository.save(entity), UserDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    private void addHateoasLinks(UserDTO dto) {
        dto.add(linkTo(methodOn(UserController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(UserController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(UserController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(UserController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(UserController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));

    }
}
