package com.example.coronitaapi.persistance.repositories;

import com.example.coronitaapi.persistance.entities.pivots.UserRole;
import com.example.coronitaapi.persistance.entities.projections.RoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query(value = "SELECT roles.* from users_roles " +
            "INNER JOIN users ON users_roles.user_id = users.id " +
            "INNER JOIN roles ON users_roles.role_id = roles.id " +
            "WHERE users_roles.user_id = :userId", nativeQuery = true)
    List<RoleProjection> findRolesByUserId(Long userId);
}
