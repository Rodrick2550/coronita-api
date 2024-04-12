package com.example.coronitaapi.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vehicle;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateOfAppointment;

    @Column
    @JsonFormat(pattern = "HH:mm")
    private String hour;

    @Column
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
