package com.db.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.domain.Trade;
import com.db.trade.exception.TradeStoreException;
import com.db.trade.service.TradeService;

@RestController("/trades")
public class TradeController {

  @Autowired
  private TradeService tradeService;
  
  @PostMapping
  public void storeTrade(Trade trade) throws TradeStoreException {
    tradeService.storeTrade(trade);
  }
}
