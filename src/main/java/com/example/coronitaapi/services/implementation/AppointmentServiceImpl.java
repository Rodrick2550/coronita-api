package com.example.coronitaapi.services.implementation;

import com.example.coronitaapi.persistance.entities.Appointment;
import com.example.coronitaapi.persistance.repositories.IAppointmentRepository;
import com.example.coronitaapi.services.interfaces.IAppointmentService;
import com.example.coronitaapi.web.dtos.requests.CreateAppointmentRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateAppointmentRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import com.example.coronitaapi.web.mappers.AppointmentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

    private final AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public BaseResponse get(Long id) {
        Appointment appointment = this.findOneAndEnsureExist(id);

        return BaseResponse.builder()
                .data(appointmentMapper.toCreateAppointmentResponse(appointment))
                .message("Appointment retrieved")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateAppointmentRequest request) {
        System.out.println(appointmentMapper.toAppointment(request).getDateOfAppointment());
        System.out.println(request.getDateOfAppointment());
        System.out.println(request.getHour());
        System.out.println(request.getInstructions());
        System.out.println(request.getVehicle());

        Appointment appointment = appointmentRepository.save(appointmentMapper.toAppointment(request));

        return BaseResponse.builder()
                .data(appointmentMapper.toCreateAppointmentResponse(appointment))
                .message("Appointment created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateAppointmentRequest updateAppointmentRequest) {
        Appointment appointment = this.findOneAndEnsureExist(id);

        appointment.setVehicle(updateAppointmentRequest.getVehicle());
        appointment.setInstructions(updateAppointmentRequest.getInstructions());

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        return BaseResponse.builder()
                .data(appointmentMapper.toUpdateAppointmentResponse(updatedAppointment))
                .message("Data appointment updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {

        Appointment appointment = this.findOneAndEnsureExist(id);

        appointmentRepository.delete(appointment);

        return BaseResponse.builder()
                .message("Appointment deleted")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Appointment findOneAndEnsureExist(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Appointment doesn't exist"));

    }

    /*@Override
    //public List<Appointment> findbyDateandTime(Date date, Time time) {
        //return null;
    }*/
}
