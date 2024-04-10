package com.example.coronitaapi.persistance.entities.projections;

import com.example.coronitaapi.persistance.entities.pivots.UserRole;

import java.util.List;

public interface RoleProjection {
    Long getId();

    String getName();

    List<UserRole> getUserRoles();
}
