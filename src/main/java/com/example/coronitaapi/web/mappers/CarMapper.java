package com.example.coronitaapi.web.mappers;

import com.example.coronitaapi.persistance.entities.Car;
import com.example.coronitaapi.web.dtos.requests.CreateCarRequest;
import com.example.coronitaapi.web.dtos.responses.CreateCarResponse;
import com.example.coronitaapi.web.dtos.responses.UpdateCarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CreateCarResponse toCreateCarResponse(Car car);

    Car toCar(CreateCarRequest createCarRequest);

    UpdateCarResponse toUpdateCarResponse(Car car);
}
