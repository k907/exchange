package com.kuzmenko.exchange.controller;

import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<Customer> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/create")
    public int createUser(@RequestBody Customer user) {
        return userService.createUser(user);
    }
}
