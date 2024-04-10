package com.example.coronitaapi.services.implementation;

import com.example.coronitaapi.persistance.entities.User;
import com.example.coronitaapi.persistance.repositories.IUserRepository;
import com.example.coronitaapi.services.interfaces.IUserService;
import com.example.coronitaapi.web.dtos.requests.CreateUserRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateUserRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import com.example.coronitaapi.web.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse get(Long id) {
        User user = this.findOneAndEnsureExist(id);

        return BaseResponse.builder()
                .data(userMapper.toCreateUserResponse(user))
                .message("User retrieved")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateUserRequest request) {
        if (userRepository.getByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        //request.setPassword(encodePassword(request.getPassword()));

        User user = userRepository.save(userMapper.toUser(request));

        return BaseResponse.builder()
                .data(userMapper.toCreateUserResponse(user))
                .message("User created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }



    @Override
    public BaseResponse update(Long id, UpdateUserRequest request) {
        User user = this.findOneAndEnsureExist(id);

        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());


        User updatedUser = userRepository.save(user);

        return BaseResponse.builder()
                .data(userMapper.toUpdateUserResponse(updatedUser))
                .message("Data user updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {
        User user = this.findOneAndEnsureExist(id);

        userRepository.delete(user);

        return BaseResponse.builder()
                .message("User deleted")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
    }

    @Override
    public User findOneAndEnsureExist(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @Override
    public User findOneAndEnsureExist(String email) {
        return userRepository.getByEmail(email).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.empty();
    }


    /*private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

     */
}
