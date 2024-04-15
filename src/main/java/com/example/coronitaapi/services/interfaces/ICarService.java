package com.example.coronitaapi.services.interfaces;

import com.example.coronitaapi.persistance.entities.Car;
import com.example.coronitaapi.web.dtos.requests.CreateCarRequest;
import com.example.coronitaapi.web.dtos.requests.UpdateCarRequest;
import com.example.coronitaapi.web.dtos.responses.BaseResponse;

public interface ICarService {

    BaseResponse get (Long id);

    BaseResponse create (CreateCarRequest createCarRequest);

    BaseResponse update (Long id, UpdateCarRequest updateCarRequest);

    BaseResponse delete (Long id);

    Car findOneAndEnsureExist(Long id);




}
