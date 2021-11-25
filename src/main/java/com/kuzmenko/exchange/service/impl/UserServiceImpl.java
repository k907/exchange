package com.kuzmenko.exchange.service.impl;

import com.kuzmenko.exchange.entity.CurrencyEnum;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import com.kuzmenko.exchange.repository.UserRepository;
import com.kuzmenko.exchange.repository.WalletRepository;
import com.kuzmenko.exchange.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    /**
     * Create a user with three wallets
     *
     * @param user - customer
     * @return customer id
     */
    @Override
    public int createUser(Customer user) {

        Customer newCustomer = userRepository.save(user);

        newCustomer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.EUR)
                .setAmmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        newCustomer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.USD)
                .setAmmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        newCustomer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.UAH)
                .setAmmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        userRepository.save(newCustomer);

        log.warn("Create user: userId = " + newCustomer.getId());

        // TODO отправка нотификации
        // .....

        return newCustomer.getId();
    }

    @Override
    public List<Customer> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Customer findUserByLastName(String lastName) {
        return findUserByLastName(lastName);
    }

    @Override
    public Customer findUserByPhone(String phone) {
        return findUserByPhone(phone);
    }

    @Override
    public List<Wallet> getWalletsByPhone(String phone) {
        return null;
    }
}
