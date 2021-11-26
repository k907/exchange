package com.kuzmenko.exchange.exсeption;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExceptionData {
    private String info;
}
