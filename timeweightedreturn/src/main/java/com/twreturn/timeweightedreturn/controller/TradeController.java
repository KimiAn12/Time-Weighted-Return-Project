package com.twreturn.timeweightedreturn.controller;

import com.twreturn.timeweightedreturn.Trade;
import com.twreturn.timeweightedreturn.repository.TradeRepository;
import com.twreturn.timeweightedreturn.repository.PortfolioRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeRepository tradeRepo;
    private final PortfolioRepository portfolioRepo;

    public TradeController(TradeRepository tradeRepo, PortfolioRepository portfolioRepo) {
        this.tradeRepo = tradeRepo;
        this.portfolioRepo = portfolioRepo;
    }

    @PostMapping
    public ResponseEntity<com.twreturn.timeweightedreturn.Trade> createTrade(@RequestBody Trade trade) {
        return ResponseEntity.ok(tradeRepo.save(trade));
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<com.twreturn.timeweightedreturn.Trade> getTrades(@PathVariable Long portfolioId) {
        return tradeRepo.findByPortfolioId(portfolioId);
    }
}
