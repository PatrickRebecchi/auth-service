package com.patrick.auth_service.service;

import com.patrick.auth_service.dto.RegisterDTO;
import com.patrick.auth_service.entity.User;
import com.patrick.auth_service.repository.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RepositoryUser repository;

    @Transactional
    public RegisterDTO register(RegisterDTO dto){
        User user = new User();



        user = repository.save(user);
    }
}
