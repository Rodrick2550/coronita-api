package com.example.coronitaapi.web.controllers;

import com.example.coronitaapi.services.interfaces.IUserService;
import com.example.coronitaapi.web.dtos.requests.CreateUserRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateUserRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = userService.get(id);
        return response.apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateUserRequest request) {
        BaseResponse response = userService.create(request);
        return response.apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        BaseResponse response = userService.update(id, request);
        return response.apply();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        BaseResponse response = userService.delete(id);
        return response.apply();
    }
}
