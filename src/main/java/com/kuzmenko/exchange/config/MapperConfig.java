package com.kuzmenko.exchange.config;


import com.kuzmenko.exchange.dto.CustomerDTO;
import com.kuzmenko.exchange.dto.WalletDTO;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Customer.class, CustomerDTO.class)
                .mapNulls(true)
                .byDefault()
                .register();
        factory.classMap(Wallet.class, WalletDTO.class)
                .mapNulls(true)
                .byDefault()
                .register();
    }
}
