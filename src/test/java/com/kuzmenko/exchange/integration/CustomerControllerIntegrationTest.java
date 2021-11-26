package com.kuzmenko.exchange.integration;

import com.kuzmenko.exchange.entity.CurrencyEnum;
import com.kuzmenko.exchange.entity.Customer;
import com.kuzmenko.exchange.entity.Wallet;
import com.kuzmenko.exchange.exсeption.ExceptionData;
import com.kuzmenko.exchange.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    private final String URL = "/api/users";
    private final String PHONE_NUMBER = "123456789";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetAllUsers() {
        addCustomerToDatabase(createCustomer());
        addCustomerToDatabase(createCustomer().setFirstName("Irina").setPhone(PHONE_NUMBER + "1"));
        addCustomerToDatabase(createCustomer().setFirstName("Seva").setPhone(PHONE_NUMBER + "2"));

        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Customer>>() {
                });


        List<Customer> customers = response.getBody();
        System.out.println(customers);
        assertThat(customers, hasSize(3));
    }

    @Test
    public void testCreateCustomerAndWallets() {
        Customer customer = createCustomer();
        Integer id = restTemplate.postForObject(URL + "/create", customer, Integer.class);
        assertThat(id, notNullValue());

        Customer customer1 = customerRepository.findById(id).get();
        assertThat(customer.getPhone(), is(customer1.getPhone()));
        assertThat(customer1.getWallets(), hasSize(3));
    }

    @Test
    public void testCustomerNotFoundByPhoneException() {
        ExceptionData data = restTemplate.getForObject(URL + "/{phone}", ExceptionData.class, 1);
        assertThat(data.getInfo(), is("Customer with phone = 1 not found"));
        //assertThrows(CustomerNotFoundException.class, () -> restTemplate.getForObject(URL + "/{phone}", Customer.class, 1));
    }

    // ошибка переполнения стека
//    @Test
//    public void testGetCustomerByPhone() {
//        addCustomerToDatabase(createCustomer());
//
//        Customer customer = restTemplate.getForObject(URL + "/{phone}", Customer.class, PHONE_NUMBER);
//        System.out.println(customer);
//        assertThat(customer, notNullValue());
//        assertThat(customer.getPhone(), is(PHONE_NUMBER));
//    }

    @Test
    public void testGetWalletsByPhone() {
        addCustomerToDatabase(createCustomer());

        ResponseEntity<List<Wallet>> response = restTemplate.exchange(
                URL + "/{phone}/wallet", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Wallet>>() {
                },
                PHONE_NUMBER);

        List<Wallet> wallets = response.getBody();
        assertThat(wallets, hasSize(3));
    }

    @AfterEach
    public void resetDb() {
        customerRepository.deleteAll();
    }

    private Customer createCustomer() {
        return new Customer()
                .setFirstName("Igor")
                .setLastName("Ivanov")
                .setPhone(PHONE_NUMBER);
    }

    public Customer addCustomerToDatabase(Customer customer) {

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.USD.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.EUR.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        customer.addWallet(new Wallet()
                .setCurrency(CurrencyEnum.UAH.cur())
                .setAmount(BigDecimal.ZERO)
                .setLastModify(new Timestamp(System.currentTimeMillis())));

        return customerRepository.saveAndFlush(customer);
    }
}
