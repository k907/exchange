package com.kuzmenko.exchange.service.impl;

import com.kuzmenko.exchange.config.MapperConfig;
import com.kuzmenko.exchange.entity.CurrencyEnum;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import com.kuzmenko.exchange.repository.CustomerRepository;
import com.kuzmenko.exchange.repository.WalletRepository;
import com.kuzmenko.exchange.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    MapperConfig dtoMapper;

    /**
     * Create customer and wallets
     *
     * @param customer - customer
     * @return customer id
     */
    @Override
    public int createCustomer(Customer customer) {

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.USD.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.EUR.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.UAH.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        customerRepository.save(customer);

        log.warn("Create customer: userId = " + customer.getId());

        // TODO отправка нотификации
        // .....

        return customer.getId();
    }

    @Override
    public List<Customer> findAllUsers() {
        return customerRepository.findAll();
        //return userRepository.findAll().stream().map(customer -> dtoMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public Customer findUserByPhone(String phone) {
        return findUserByPhone(phone);
    }

    @Override
    public List<Wallet> getWalletsByPhone(String phone) {
        return walletRepository.findWalletsByCustomer_Phone(phone);
    }
}
