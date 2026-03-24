package com.patrick.auth_service.dto;

public record UserResponseDTO(
        Long id,
        String name,
        Integer age,
        String phone,
        String email
) {}