package com.example.coronitaapi.web.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarResponse {

    private String brand;


    private String model;
    @JsonFormat(pattern = "yyyy")
    private String yearOfModel;

    private String color;
}
