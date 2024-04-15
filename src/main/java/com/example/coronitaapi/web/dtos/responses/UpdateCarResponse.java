package com.example.coronitaapi.web.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCarResponse {

    private String brand;

    private String model;

    private String year;

    private String color;
}
