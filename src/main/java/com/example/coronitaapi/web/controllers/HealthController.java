package com.example.coronitaapi.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("default")
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
