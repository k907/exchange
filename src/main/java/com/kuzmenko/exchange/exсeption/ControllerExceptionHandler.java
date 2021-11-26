package com.kuzmenko.exchange.exсeption;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionData> handlerException(Exception ex) {
        ExceptionData data = new ExceptionData().setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionData> handlerException(CustomerNotFoundException ex) {
        ExceptionData data = new ExceptionData().setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionData> handlerException(WalletNotFoundException ex) {
        ExceptionData data = new ExceptionData().setInfo(ex.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
