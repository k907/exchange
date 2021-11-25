package com.kuzmenko.exchange.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class WalletDTO {
    private int id;
    private String currency;
    private BigDecimal amount;
}
