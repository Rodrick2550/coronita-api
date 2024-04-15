package com.example.coronitaapi.web.controllers;

import com.example.coronitaapi.services.interfaces.ICarService;
import com.example.coronitaapi.web.dtos.requests.CreateCarRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateCarRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = carService.get(id);
        return response.apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateCarRequest request) {
        BaseResponse response = carService.create(request);
        return response.apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateCarRequest request) {
        BaseResponse response = carService.update(id, request);
        return response.apply();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        BaseResponse response = carService.delete(id);
        return response.apply();
    }

}
