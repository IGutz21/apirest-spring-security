package com.paqtafood;

import com.paqtafood.models.ERole;
import com.paqtafood.models.RoleEntity;
import com.paqtafood.models.UserEntity;
import com.paqtafood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class PaqtafoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaqtafoodApplication.class, args);
    }

//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            UserEntity userEntity = UserEntity.builder()
//                    .email("joe@gmail.com")
//                    .username("joe")
//                    .password(passwordEncoder.encode("1234"))
//                    .roles(Set.of(RoleEntity.builder()
//                            .name(ERole.valueOf(ERole.ADMIN.name()))
//                            .build()))
//                    .build();
//
//            UserEntity userEntity2 = UserEntity.builder()
//                    .email("angie@gmail.com")
//                    .username("angie")
//                    .password(passwordEncoder.encode("1234"))
//                    .roles(Set.of(RoleEntity.builder()
//                            .name(ERole.valueOf(ERole.USER.name()))
//                            .build()))
//                    .build();
//
//            UserEntity userEntity3 = UserEntity.builder()
//                    .email("jorge@gmail.com")
//                    .username("jorge")
//                    .password(passwordEncoder.encode("1234"))
//                    .roles(Set.of(RoleEntity.builder()
//                            .name(ERole.valueOf(ERole.INVITED.name()))
//                            .build()))
//                    .build();
//
//            userRepository.save(userEntity);
//            userRepository.save(userEntity2);
//            userRepository.save(userEntity3);
//        };
//    }


}
