package com.example.coronitaapi.web.dtos.requests;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarRequest {

    private String brand;


    private String model;

    private String year;

    private String color;
}
