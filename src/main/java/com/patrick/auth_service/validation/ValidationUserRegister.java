package com.patrick.auth_service.validation;

import com.patrick.auth_service.dto.RegisterDTO;

public interface ValidationUserRegister {

    void validar(RegisterDTO dto);
}
