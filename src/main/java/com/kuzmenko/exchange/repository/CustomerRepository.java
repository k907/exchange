package com.kuzmenko.exchange.repository;

import com.kuzmenko.exchange.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findUserByPhone(String phone);
}
