package com.kuzmenko.exchange.service.impl;

import com.kuzmenko.exchange.entity.CurrencyEnum;
import com.kuzmenko.exchange.entity.Rate;
import com.kuzmenko.exchange.entity.RateRawData;
import com.kuzmenko.exchange.repository.RateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public List<Rate> getAllRates() {
        log.info("call getRate()");
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        ResponseEntity<List<RateRawData>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<RateRawData>>() {
                });

        List<RateRawData> rateRawData = response.getBody();

        List<Rate> listRates = rateRawData.stream()
                //.filter(currency -> currency.equals("USD") || currency.equals("EUR"))
                .map(rawRate -> new Rate()
                        .setCurrency(rawRate.getCcy())
                        .setBuy(Float.valueOf(rawRate.getBuy()))
                        .setSale(Float.valueOf(rawRate.getSale()))
                        .setReceive(new Timestamp(System.currentTimeMillis()))
                ).collect(Collectors.toList());

        return listRates;
    }
}
