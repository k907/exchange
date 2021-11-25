package com.kuzmenko.exchange.service;

import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;

import java.util.List;

public interface UserService {

    int createUser(Customer user);

    List<Customer> findAllUsers();

    Customer findUserByLastName(String lastName);

    Customer findUserByPhone(String phone);

    List<Wallet> getWalletsByPhone(String phone);
}
