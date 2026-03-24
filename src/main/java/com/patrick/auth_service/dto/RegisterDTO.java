package com.patrick.auth_service.dto;

import jakarta.validation.constraints.*;


public record RegisterDTO(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @NotNull @Min(value = 0, message = "age must be greater than or equal to 0")
        Integer age,
        @NotBlank(message = "phone cannot be empty")
        String phone,
        @NotBlank(message = "email cannot be empty") @Email(message = "invalid email")
        String email,
        @NotBlank(message = "password cannot be empty") @Size(min = 4, message = "password must have at least 4 characters")
        String password
) {
}
