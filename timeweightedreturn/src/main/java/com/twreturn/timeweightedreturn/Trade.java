package com.twreturn.timeweightedreturn;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asset;
    private String type; // BUY or SELL
    private double quantity;
    private double price;
    private LocalDate tradeDate;

    @ManyToOne
    private Portfolio portfolio;
}
