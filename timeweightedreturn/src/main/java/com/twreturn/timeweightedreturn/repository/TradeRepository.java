package com.twreturn.timeweightedreturn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.twreturn.timeweightedreturn.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByPortfolioId(Long portfolioId);
}
