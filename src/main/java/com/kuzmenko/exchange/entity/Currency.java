package com.kuzmenko.exchange.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Currency {
    private String curr;
    private double sale;
    private double buy;
}
