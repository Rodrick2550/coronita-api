package com.example.coronitaapi.persistance.repositories;

import com.example.coronitaapi.persistance.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

   // List<Appointment> findbyDateandTime(Date date, Time time);
}
