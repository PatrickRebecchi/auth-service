package com.patrick.auth_service.controller;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    private UserService service;


    @PostMapping()                                              // Objeto(CadastrarClienteDTO) -- Parametro(dto) service
    public RegisterDTO register(@RequestBody @Valid RegisterDTO dto){
        return this.service.register(dto);
    }
}
