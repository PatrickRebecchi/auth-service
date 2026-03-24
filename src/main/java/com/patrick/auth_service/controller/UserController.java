package com.patrick.auth_service.controller;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.dto.UserResponseDTO;
import com.patrick.auth_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid RegisterDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.register(dto));
    }
}
