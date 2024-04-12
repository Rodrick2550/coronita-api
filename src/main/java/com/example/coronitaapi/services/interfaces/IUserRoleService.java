package com.example.coronitaapi.services.interfaces;

import com.example.coronitaapi.web.dtos.responses.GetRoleResponse;

import java.util.List;

public interface IUserRoleService {

    List<GetRoleResponse>getRolesByUserId(Long userId);
}
