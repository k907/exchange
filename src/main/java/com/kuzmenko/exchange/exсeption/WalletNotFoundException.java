package com.kuzmenko.exchange.exсeption;

public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException(String message) {
        super(message);
    }
}
