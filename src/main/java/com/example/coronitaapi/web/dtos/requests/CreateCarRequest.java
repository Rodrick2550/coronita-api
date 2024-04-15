package com.example.coronitaapi.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarRequest {

    private String brand;


    private String model;
    //@JsonFormat(pattern = "yyyy")
    private String yearOfModel;

    private String color;
}
