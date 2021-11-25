package com.kuzmenko.exchange.controller;

import com.kuzmenko.exchange.config.MapperConfig;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import com.kuzmenko.exchange.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    MapperConfig mapper;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllUsers() {
        return customerService.findAllUsers();
    }

    @PostMapping("/create")
    public int createUser(@RequestBody Customer user) {
        return customerService.createCustomer(user);
    }

    @GetMapping("/{phone}")
    public Customer getCustomerByPhone(@PathVariable String phone) {
        System.out.println("Вызов getCustomerByPhone = " + phone);
        return customerService.findUserByPhone(phone);
    }

    @GetMapping("/{phone}/wallet")
    public List<Wallet> getWalletsByPhone(@PathVariable String phone) {
        return customerService.getWalletsByPhone(phone);
        //return userService.getWalletsByPhone(phone).stream().map(wallet -> mapper.map(wallet, WalletDTO.class)).collect(Collectors.toList());
    }
}
