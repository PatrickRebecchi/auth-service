package com.patrick.auth_service.service;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.dto.UserResponseDTO;
import com.patrick.auth_service.entity.User;
import com.patrick.auth_service.repository.RepositoryUser;
import com.patrick.auth_service.validation.ValidationRegisterUser;
import com.patrick.auth_service.validation.ValidationUserRegister;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RepositoryUser repository;

    @Autowired
    private List<ValidationUserRegister> validationUserRegisters;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDTO register(RegisterDTO dto) {

        validationUserRegisters.forEach(u -> u.validar(dto));

        User user = new User(dto);

        user.setPassword(passwordEncoder.encode(dto.password()));

        user = repository.save(user);
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getPhone(),
                user.getEmail()
        );
    }
}
