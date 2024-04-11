package com.example.coronitaapi.services.implementation;

import com.example.coronitaapi.persistance.entities.projections.RoleProjection;
import com.example.coronitaapi.persistance.repositories.IUserRoleRepository;
import com.example.coronitaapi.services.interfaces.IUserRoleService;
import com.example.coronitaapi.web.dtos.responses.GetRoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    private final IUserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(IUserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<GetRoleResponse> getRolesByUserId(Long userId) {
       List<RoleProjection> roles = userRoleRepository.findRolesByUserId(userId);

       return roles.stream().map(this::toRoleResponse)
               .collect(Collectors.toList());

    }

    GetRoleResponse toRoleResponse(RoleProjection roleProjection) {
        GetRoleResponse getRoleResponse = new GetRoleResponse();

        getRoleResponse.setId(roleProjection.getId());
        getRoleResponse.setName(roleProjection.getName());

        return getRoleResponse;
    }
}
