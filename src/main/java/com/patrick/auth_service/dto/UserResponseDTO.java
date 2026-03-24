package com.patrick.auth_service.dto;

public record UserResponseDTO(
        Long id,
        String fullName,
        Integer age,
        String phone,
        String email
) {}