package com.example.coronitaapi.persistance.entities.projections;

import com.example.coronitaapi.persistance.entities.pivots.UserRole;

import java.util.List;

public interface UserProjection {
    Long getId();

    String getName();

    String getLastname();

    String getEmail();

    List<UserRole> getUserRoles();
}
