package com.kuzmenko.exchange.dto;

import com.kuzmenko.exchange.entity.CurrencyEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class WalletDto {
    Long id;
    CurrencyEnum currency;
    BigDecimal ammount;
}
