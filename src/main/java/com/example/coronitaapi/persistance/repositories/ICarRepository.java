package com.example.coronitaapi.persistance.repositories;

import com.example.coronitaapi.persistance.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car, Long> {


}
