package com.paqtafood.services;

import com.paqtafood.controllers.request.CreateUserDTO;
import com.paqtafood.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    UserEntity findById(Long id);
    UserEntity findByUsername(String username);
    UserEntity save(CreateUserDTO userDTO);
    UserEntity update(Long id, CreateUserDTO userDTO);
    void deleteById(Long id);
}
