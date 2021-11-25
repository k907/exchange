package com.kuzmenko.exchange.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "wallet")
@Accessors(chain = true)
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String currency;

    BigDecimal amount;

    @Column(name = "last_update")
    Timestamp lastModify;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    Customer customer;

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", currency=" + currency +
                ", ammount=" + amount +
                ", lastModify=" + lastModify +
                '}';
    }
}
