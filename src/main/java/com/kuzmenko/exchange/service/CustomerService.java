package com.kuzmenko.exchange.service;

import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;

import java.util.List;

public interface CustomerService {

    int createCustomer(Customer user);

    List<Customer> findAllUsers();

    Customer findUserByPhone(String phone);

    List<Wallet> getWalletsByPhone(String phone);
}
