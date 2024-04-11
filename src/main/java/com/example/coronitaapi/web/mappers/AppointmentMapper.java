package com.example.coronitaapi.web.mappers;

import com.example.coronitaapi.persistance.entities.Appointment;
import com.example.coronitaapi.web.dtos.requests.CreateAppointmentRequest;
import com.example.coronitaapi.web.dtos.responses.CreateAppointmentResponse;
import com.example.coronitaapi.web.dtos.responses.UpdateAppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    CreateAppointmentResponse toCreateAppointmentResponse(Appointment
                                                          appointment);

    Appointment toAppointment(CreateAppointmentRequest
                              createAppointmentRequest);

    UpdateAppointmentResponse toUpdateAppointmentResponse(Appointment
                                                          appointment);
}
