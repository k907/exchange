package com.kuzmenko.exchange.controller;

import com.kuzmenko.exchange.entity.Rate;
import com.kuzmenko.exchange.service.impl.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/rate")
    public List<Rate> getAllRates() {
        return exchangeService.getAllRates();
    }
}
