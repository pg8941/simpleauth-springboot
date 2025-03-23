// src/main/java/com/example/simpleauth/repository/RoleRepository.java
package com.example.simpleauth.repository;

import com.example.simpleauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name); // Add this method
}