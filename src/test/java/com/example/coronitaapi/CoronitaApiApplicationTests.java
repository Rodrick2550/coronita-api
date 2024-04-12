package com.example.coronitaapi;

import com.example.coronitaapi.persistance.entities.User;
import com.example.coronitaapi.persistance.repositories.IUserRepository;
import com.example.coronitaapi.services.implementation.UserServiceImpl;
import com.example.coronitaapi.web.dtos.requests.CreateUserRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateUserRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import com.example.coronitaapi.web.mappers.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoronitaApiApplicationTests {
/*
    @Mock
    private UserServiceImpl userService;

    @Mock
    private IUserRepository userRepository;

    private UserMapper userMapper;

    private User user;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository);

        user = new User();
        user.setId(89L);
        user.setName("Test");
    }

    @Test
    public void whenGivenId_shouldReturnUser_ifFound() {
        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));

        BaseResponse response = userService.get(user.getId());

        Assertions.assertTrue(response.getSuccess());
        Assertions.assertSame(response.getHttpStatus(), HttpStatus.OK);
    }

    @Test
    public void should_throw_exception_when_user_doesnt_exist_get() {
        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        assertThrows(RuntimeException.class, () -> userService.get(user.getId()));
    }

    @Test
    public void testCreateUser() {
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Test");
        request.setLastName("User");
        request.setEmail("usuario@prueba.com");
        request.setPassword("Test123@");


        when(userService.getByEmail(request.getEmail())).thenReturn(Optional.empty());

        BaseResponse response = userService.create(request);

        Assertions.assertTrue(response.getSuccess());
        Assertions.assertSame(response.getHttpStatus(), HttpStatus.CREATED);
    }

    @Test
    public void should_throw_exception_when_user_doesnt_exist() {
        UpdateUserRequest request = new UpdateUserRequest();

        user.setName("Updated");

        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));

        assertThrows(RuntimeException.class, () -> userService.update(user.getId(), request));
    }


*/

}
