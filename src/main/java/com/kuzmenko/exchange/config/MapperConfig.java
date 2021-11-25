package com.kuzmenko.exchange.config;


import com.kuzmenko.exchange.dto.CustomerDto;
import com.kuzmenko.exchange.dto.WalletDto;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Customer.class, CustomerDto.class)
                .mapNulls(false)
                .byDefault()
                .register();
        factory.classMap(CustomerDto.class, Customer.class)
                .mapNulls(false)
                .byDefault()
                .register();
        factory.classMap(Wallet.class, WalletDto.class)
                .mapNulls(false)
                .byDefault()
                .register();
    }
}
