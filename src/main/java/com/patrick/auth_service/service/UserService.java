package com.patrick.auth_service.service;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.dto.UserResponseDTO;
import com.patrick.auth_service.entity.User;
import com.patrick.auth_service.exception.UserException;
import com.patrick.auth_service.repository.UserRepository;
import com.patrick.auth_service.validation.ValidationRegisterUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private List<ValidationRegisterUser> validationUserRegisters;

//    @Autowired
//    private List<ValidationRegisterUser> validationUserRegisters;

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
                user.getFullName(),
                user.getAge(),
                user.getPhone(),
                user.getEmail()
        );
    }

    public List<UserResponseDTO> searchUsers() {
        return converteDados(repository.findAll());
    }

    private List<UserResponseDTO> converteDados(List<User> users) {
        return users.stream()
                .map(u -> new UserResponseDTO(
                        u.getId(),
                        u.getFullName(),
                        u.getAge(),
                        u.getPhone(),
                        u.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        User u = repository.findById(id)
                .orElseThrow(() -> new UserException("User not found"));

        return new UserResponseDTO(
                u.getId(),
                u.getFullName(),
                u.getAge(),
                u.getPhone(),
                u.getEmail()
        );
    }
}
