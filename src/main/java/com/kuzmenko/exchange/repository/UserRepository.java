package com.kuzmenko.exchange.repository;

import com.kuzmenko.exchange.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {

    Customer findUserByFirstName(String name);

    Customer findUserByPhone(String phone);
}
