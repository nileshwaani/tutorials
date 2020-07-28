package com.db.trade.service;

import static com.db.trade.exception.ErrorCode.OLDER_MATURITY_DATE;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.trade.domain.Trade;
import com.db.trade.exception.ErrorCode;
import com.db.trade.exception.TradeStoreException;
import com.db.trade.repository.TradeRepository;

@Service
public class TradeService {

  private static final int FETCH_SIZE = 10;

  @Autowired
  private TradeRepository tradeRepository;

  public void storeTrade(Trade trade) {

    if (trade.getMaturityDate().compareTo(LocalDate.now()) < 0) {
      throw new TradeStoreException(OLDER_MATURITY_DATE);
    }

    if (getMaximumVersionForTrade(trade.getTradeId()).compareTo(trade.getVersion()) > 0) {
      throw new TradeStoreException(ErrorCode.LOWER_VERSION_ERROR);
    }
    tradeRepository.save(trade);
  }

  public void expireTradesWithCrossedMaturityDate() {
    List<Trade> tradesWithCrossedMaturityDate = tradeRepository.getTradesWithCrossedMaturityDate(FETCH_SIZE);
    while (!tradesWithCrossedMaturityDate.isEmpty()) {
      tradesWithCrossedMaturityDate.forEach(trade -> trade.setExpired(true));
      tradeRepository.saveAll(tradesWithCrossedMaturityDate);
      tradesWithCrossedMaturityDate = tradeRepository.getTradesWithCrossedMaturityDate(FETCH_SIZE);
    }
  }

  private Integer getMaximumVersionForTrade(String tradeId) {
    return tradeRepository.getMaximumVersionForTrade(tradeId);
  }
}
