package com.example.coronitaapi.web.controllers;

import com.example.coronitaapi.services.interfaces.IAppointmentService;
import com.example.coronitaapi.web.dtos.requests.CreateAppointmentRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateAppointmentRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = appointmentService.get(id);
        return response.apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateAppointmentRequest request) {
        BaseResponse response = appointmentService.create(request);
        return response.apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateAppointmentRequest request) {
        BaseResponse response = appointmentService.update(id, request);
        return response.apply();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        BaseResponse response = appointmentService.delete(id);
        return response.apply();
    }
}
