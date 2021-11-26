package com.kuzmenko.exchange.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RateRawData {
    private String ccy;
    private String base_ccy;
    private String buy;
    private String sale;
}
