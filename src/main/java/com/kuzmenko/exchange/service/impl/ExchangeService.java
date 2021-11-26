package com.kuzmenko.exchange.service.impl;

import com.kuzmenko.exchange.entity.Rate;

import java.util.List;

public interface ExchangeService {
    List<Rate> getAllRates();
}
