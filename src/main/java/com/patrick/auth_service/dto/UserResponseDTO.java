package com.patrick.auth_service.dto;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        boolean enabled
) {}