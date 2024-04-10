package com.example.coronitaapi.services.interfaces;

import com.example.coronitaapi.persistance.entities.User;
import com.example.coronitaapi.web.dtos.requests.CreateUserRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateUserRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;

import java.util.Optional;

public interface IUserService {

    BaseResponse get (Long id);
    BaseResponse create (CreateUserRequest createUserRequest);
    BaseResponse update (Long id, UpdateUserRequest updateUserRequest);

    BaseResponse delete (Long id);

    User findOneAndEnsureExist(Long id);
    User findOneAndEnsureExist(String email);

    Optional<User> getByEmail(String email);
}
