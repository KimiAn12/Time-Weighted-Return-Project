package com.twreturn.timeweightedreturn;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    // One portfolio can have many trades
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trade> trades = new ArrayList<>();

    // No-arg constructor (required by JPA)
    public Portfolio() {}

    // All-args constructor (without id, since id is generated)
    public Portfolio(String name, User user) {
        this.name = name;
        this.user = user;
    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Trade> getTrades() { return trades; }
    public void setTrades(List<Trade> trades) { this.trades = trades; }

    // Helper methods to manage bi-directional relationship

    public void addTrade(Trade trade) {
        trades.add(trade);
        trade.setPortfolio(this);
    }

    public void removeTrade(Trade trade) {
        trades.remove(trade);
        trade.setPortfolio(null);
    }
}
