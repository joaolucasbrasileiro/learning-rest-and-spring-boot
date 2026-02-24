package com.lucasbrasileiro.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.lucasbrasileiro.data.dto.v1.UserDTO;
import com.lucasbrasileiro.model.User;

public class MockUser {

    public User mockEntity() {
        return mockEntity(0);
    }

    public UserDTO mockDTO() {
        return mockDTO(0);
    }

    public List<User> mockEntityList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockEntity(i));
        }
        return users;
    }

    public List<UserDTO> mockDTOList() {
        List<UserDTO> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockDTO(i));
        }
        return users;
    }

    public User mockEntity(Integer number) {
        User user = new User();
        user.setId(number.longValue());
        user.setUsername("Username Test" + number);
        user.setPassword("Password Test" + number);
        user.setEmail("Email Test" + number);
        user.setGender((number % 2 == 0) ? "Male" : "Female");
        return user;
    }

    public UserDTO mockDTO(Integer number) {
        UserDTO user = new UserDTO();
        user.setId(number.longValue());
        user.setUsername("Username Test" + number);
        user.setPassword("Password Test" + number);
        user.setEmail("Email Test" + number);
        user.setGender((number % 2 == 0) ? "Male" : "Female");
        return user;
    }
}