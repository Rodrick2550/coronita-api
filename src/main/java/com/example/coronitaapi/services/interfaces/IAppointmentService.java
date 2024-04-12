package com.example.coronitaapi.services.interfaces;

import com.example.coronitaapi.persistance.entities.Appointment;
import com.example.coronitaapi.persistance.entities.User;
import com.example.coronitaapi.web.dtos.requests.CreateAppointmentRequest;
import com.example.coronitaapi.web.dtos.requests.CreateUserRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateAppointmentRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateUserRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface IAppointmentService {

    BaseResponse get (Long id);
    BaseResponse create (CreateAppointmentRequest createAppointmentRequest);
    BaseResponse update (Long id, UpdateAppointmentRequest updateAppointmentRequest);

    BaseResponse delete (Long id);

    Appointment findOneAndEnsureExist(Long id);

    //List<Appointment> findbyDateandTime(Date date, Time time);
}
