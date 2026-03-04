package com.lucasbrasileiro.service;

import com.lucasbrasileiro.data.dto.v1.UserDTO;
import com.lucasbrasileiro.exception.RequiredObjectIsNullException;
import com.lucasbrasileiro.model.User;
import com.lucasbrasileiro.repository.UserRepository;
import com.lucasbrasileiro.unitetests.mapper.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    MockUser input;

    @InjectMocks
    private UserService service;

    @Mock
    UserRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockUser();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        List<User> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<UserDTO> users = service.findAll();

        assertNotNull(users);
        assertEquals(14, users.size());

        var userOne = users.get(1);

        assertNotNull(userOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("GET")));

        assertNotNull(userOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("GET")));

        assertNotNull(userOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("post")));

        assertNotNull(userOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("put")));

        assertNotNull(userOne.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("delete")));

        assertEquals("Username Test1", userOne.getUsername());
        assertEquals("Password Test1", userOne.getPassword());
        assertEquals("Email Test1", userOne.getEmail());
        assertEquals("Female", userOne.getGender());

        var userFour = users.get(4);

        assertNotNull(userFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("GET")));

        assertNotNull(userFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("GET")));

        assertNotNull(userFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("post")));

        assertNotNull(userFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("put")));

        assertNotNull(userFour.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("delete")));

        assertEquals("Username Test4", userFour.getUsername());
        assertEquals("Password Test4", userFour.getPassword());
        assertEquals("Email Test4", userFour.getEmail());
        assertEquals("Male", userFour.getGender());

        var userNine = users.get(9);

        assertNotNull(userNine.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("GET")));

        assertNotNull(userNine.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("GET")));

        assertNotNull(userNine.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("post")));

        assertNotNull(userNine.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("put")));

        assertNotNull(userNine.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("delete")));

        assertEquals("Username Test9", userNine.getUsername());
        assertEquals("Password Test9", userNine.getPassword());
        assertEquals("Email Test9", userNine.getEmail());
        assertEquals("Female", userNine.getGender());


    }

    @Test
    void findById() {
        User user = input.mockEntity(1);
        user.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(user));
        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("/api/user/v1/1")
                && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("/api/user/v1")
                && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("/api/user/v1")
                && link.getType().equals("post")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("/api/user/v1")
                && link.getType().equals("put")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("/api/user/v1/1")
                && link.getType().equals("delete")));

        assertEquals("Username Test1", result.getUsername());
        assertEquals("Password Test1", result.getPassword());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("Female", result.getGender());

    }

    @Test
    void testCreateWithNoUser() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void create() {
        User user = input.mockEntity(1);
        User persisted = user;
        persisted.setId(1L);

        UserDTO dto = input.mockDTO(1);

        when(repository.save(user)).thenReturn(persisted);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("post")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("put")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("delete")));

        assertEquals("Username Test1", result.getUsername());
        assertEquals("Password Test1", result.getPassword());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("Female", result.getGender());
    }

    @Test
    void delete() {
        User user = input.mockEntity(1);
        user.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        service.delete(user.getId());

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(any(User.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateWithNoUser() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        User user = input.mockEntity(1);
        User persisted = user;
        persisted.setId(1L);

        UserDTO dto = input.mockDTO(1);

        when(repository.findById(1L)).thenReturn(Optional.of(user));
        when(repository.save(user)).thenReturn(persisted);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("self")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("findAll")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("GET")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("create")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("post")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("update")
                        && link.getHref().endsWith("/api/user/v1")
                        && link.getType().equals("put")));

        assertNotNull(result.getLinks().stream()
                .anyMatch(link -> link.getRel().value().equals("delete")
                        && link.getHref().endsWith("/api/user/v1/1")
                        && link.getType().equals("delete")));

        assertEquals("Username Test1", result.getUsername());
        assertEquals("Password Test1", result.getPassword());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("Female", result.getGender());
    }
}