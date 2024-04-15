package com.example.coronitaapi.services.implementation;

import com.example.coronitaapi.persistance.entities.Car;
import com.example.coronitaapi.persistance.repositories.ICarRepository;
import com.example.coronitaapi.services.interfaces.ICarService;
import com.example.coronitaapi.web.dtos.requests.CreateCarRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateCarRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;
import com.example.coronitaapi.web.mappers.CarMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements ICarService {

    private final CarMapper carMapper = CarMapper.INSTANCE;

    private final ICarRepository carRepository;

    public CarServiceImpl(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public BaseResponse get(Long id) {

        Car car = findOneAndEnsureExist(id);

        return BaseResponse.builder()
                .data(carMapper.toCreateCarResponse(car))
                .message("Car retrieved")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse create(CreateCarRequest createCarRequest) {

        Car car = carRepository.save(carMapper.toCar(createCarRequest));

        return BaseResponse.builder()
                .data(carMapper.toCreateCarResponse(car))
                .message("Car created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateCarRequest updateCarRequest) {
        Car car = this.findOneAndEnsureExist(id);

        car.setBrand(updateCarRequest.getBrand());
        car.setModel(updateCarRequest.getModel());
        car.setYear(updateCarRequest.getYear());
        car.setColor(updateCarRequest.getColor());

        car = carRepository.save(car);

        return BaseResponse.builder()
                .data(carMapper.toCreateCarResponse(car))
                .message("Car updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {
        Car car = this.findOneAndEnsureExist(id);

        carRepository.delete(car);

        return BaseResponse.builder()
                .message("Car deleted")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public Car findOneAndEnsureExist(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Car doesn't exist"));
    }
}
