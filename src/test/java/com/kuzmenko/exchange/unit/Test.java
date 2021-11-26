package com.kuzmenko.exchange.unit;


import com.kuzmenko.exchange.entity.CurrencyEnum;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Locale;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class Test {

    @org.junit.jupiter.api.Test
    public void testCurrencyRate() {
        ArrayList<String > list = new ArrayList<>();
        list.add("USD");
        list.add("10");
        list.add("EUR");

        list.stream().filter(
                elem -> {
                    CurrencyEnum.valueOf(elem);
                    return true;
                }).map(elem -> elem + " __ ").forEach(System.out::println);
    }
}
