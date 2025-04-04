package com.example.scheduledevelop.controller;


import com.example.scheduledevelop.dto.RequestDto;
import com.example.scheduledevelop.dto.ResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody RequestDto requestDto) {
        userService.createUser(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById() {
        return ResponseEntity.ok(UserService.getUserById(id));
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String email) {
        userService.updateUser(id, username, email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
