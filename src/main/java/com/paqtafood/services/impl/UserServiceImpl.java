package com.paqtafood.services.impl;

import com.paqtafood.controllers.request.CreateUserDTO;
import com.paqtafood.models.ERole;
import com.paqtafood.models.RoleEntity;
import com.paqtafood.models.UserEntity;
import com.paqtafood.repository.RoleRepository;
import com.paqtafood.repository.UserRepository;
import com.paqtafood.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity save(CreateUserDTO userDTO) {

        Set<RoleEntity> roles = userDTO.getRoles().stream()
                .map(role -> {
                    Optional<RoleEntity> existingRole = roleRepository.findByName(ERole.valueOf(role));
                    return existingRole.orElseGet(() -> RoleEntity.builder()
                            .name(ERole.valueOf(role))
                            .build());
                })
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .roles(roles)
                .build();

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id, CreateUserDTO userDTO) {

        UserEntity user = userRepository.findById(id).orElse(null);

        Set<RoleEntity> roles = userDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        assert user != null;
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
