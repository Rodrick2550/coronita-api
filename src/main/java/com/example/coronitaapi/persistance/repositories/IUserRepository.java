package com.example.coronitaapi.persistance.repositories;

import com.example.coronitaapi.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users AS u WHERE u.email = :email", nativeQuery = true)
    Optional<User> getByEmail(String email);


}
