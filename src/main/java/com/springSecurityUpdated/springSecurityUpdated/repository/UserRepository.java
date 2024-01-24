package com.springSecurityUpdated.springSecurityUpdated.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springSecurityUpdated.springSecurityUpdated.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
    // You can define custom query methods here if needed.

     @Query(value = "select * from users where email = ?1", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
