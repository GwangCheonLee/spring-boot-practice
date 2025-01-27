package com.example.springbootpractice.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public void getUsers() {
        log.info("get users");
    }
    
    @PostMapping
    public void createUser() {
        log.info("create user");
    }

    @GetMapping("/{userUuid}")
    public void getUserByUuid(@PathVariable String userUuid) {
        log.info("userUuid: {}", userUuid);
    }

    @PutMapping("/{userUuid}")
    public void updateUser(@PathVariable String userUuid) {
        log.info("userUuid: {}", userUuid);
    }

    @DeleteMapping("/{userUuid}")
    public void deleteUser(@PathVariable String userUuid) {
        log.info("userUuid: {}", userUuid);
    }

}
