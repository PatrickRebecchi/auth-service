package com.patrick.auth_service.validation;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.exception.UserException;
import com.patrick.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationRegisterUser implements ValidationUserRegister{
    @Autowired
    private UserRepository repository;

    @Override
    public void validar(RegisterDTO dto){
        if (repository.existsByEmail(dto.email())){
            throw  new UserException("Email is already in use");
        }
    }
}
