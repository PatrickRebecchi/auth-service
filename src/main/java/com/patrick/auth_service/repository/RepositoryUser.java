package com.patrick.auth_service.repository;

import com.patrick.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long>{
    boolean existsByEmail(String email);

}
