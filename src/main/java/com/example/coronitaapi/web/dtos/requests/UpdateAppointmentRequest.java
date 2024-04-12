package com.example.coronitaapi.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateOfAppointment;

    @JsonFormat(pattern = "HH:mm")
    private String hour;

    private String instructions;

    private String vehicle;
}
