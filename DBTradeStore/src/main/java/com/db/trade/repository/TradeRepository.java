package com.db.trade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.domain.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Long> {

  @Query(value = "SELECT MAX(version) FROM trades WHERE trade_id = :tradeId", nativeQuery = true)
  Integer getMaximumVersionForTrade(String tradeId);

  @Query(value = "SELECT internal_id, trade_id, version, counter_party_id, book_id, maturity_date, created_date, expired " +
                 "FROM trades WHERE trade_id = :tradeId", nativeQuery = true)
  List<Trade> getTradesWithCrossedMaturityDate(Integer tradeCount);
}
