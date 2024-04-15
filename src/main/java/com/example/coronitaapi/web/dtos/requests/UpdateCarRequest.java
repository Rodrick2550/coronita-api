package com.example.coronitaapi.web.dtos.requests;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCarRequest {

    private String brand;


    private String model;

    private String year;

    private String color;
}
