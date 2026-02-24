package com.lucasbrasileiro.unitetests.mapper;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseListObjects;
import static com.lucasbrasileiro.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.lucasbrasileiro.data.dto.v1.UserDTO;
import com.lucasbrasileiro.unitetests.mapper.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lucasbrasileiro.model.User;

public class ObjectMapperTests {
    MockUser inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockUser();
    }

    @Test
    public void parseEntityToDTOTest() {
        UserDTO output = parseObject(inputObject.mockEntity(), UserDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Username Test0", output.getUsername());
        assertEquals("Password Test0", output.getPassword());
        assertEquals("Email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<UserDTO> outputList = parseListObjects(inputObject.mockEntityList(), UserDTO.class);
        UserDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Username Test0", outputZero.getUsername());
        assertEquals("Password Test0", outputZero.getPassword());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());

        UserDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Username Test7", outputSeven.getUsername());
        assertEquals("Password Test7", outputSeven.getPassword());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        UserDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Username Test12", outputTwelve.getUsername());
        assertEquals("Password Test12", outputTwelve.getPassword());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseDTOToEntityTest() {
        User output = parseObject(inputObject.mockDTO(), User.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Username Test0", output.getUsername());
        assertEquals("Password Test0", output.getPassword());
        assertEquals("Email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<User> outputList = parseListObjects(inputObject.mockDTOList(), User.class);
        User outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Username Test0", outputZero.getUsername());
        assertEquals("Password Test0", outputZero.getPassword());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());

        User outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Username Test7", outputSeven.getUsername());
        assertEquals("Password Test7", outputSeven.getPassword());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        User outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Username Test12", outputTwelve.getUsername());
        assertEquals("Password Test12", outputTwelve.getPassword());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals("Male", outputTwelve.getGender());
    }
}