package com.kuzmenko.exchange.repository;

import com.kuzmenko.exchange.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    List<Wallet> findWalletsByCustomer_Phone(String phone);
}
