package com.example.coronitaapi.web.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResponse {

    private String vehicle;

    /*@JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAppointment;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime hour;
    */
    private String instructions;
}
