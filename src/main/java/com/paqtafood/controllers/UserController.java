package com.paqtafood.controllers;

import com.paqtafood.controllers.request.CreateUserDTO;
import com.paqtafood.models.UserEntity;
import com.paqtafood.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserEntity> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/create")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(userService.save(createUserDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    public ResponseEntity<UserEntity> updateUser(@PathVariable("id") Long id, @RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(userService.save(createUserDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
