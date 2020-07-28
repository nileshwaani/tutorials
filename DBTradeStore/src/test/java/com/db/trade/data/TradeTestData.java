package com.db.trade.data;

import java.time.LocalDate;

import com.db.trade.domain.Trade;

public class TradeTestData {
  public static final Integer VERSION_01 = 1;
  public static final Integer VERSION_02 = 2;

  public static final Trade TRADE_WITH_VERSION_01 = new Trade();
  public static final Trade TRADE_WITH_OLDER_MATURITY_DATE = new Trade();

  static {
    TRADE_WITH_VERSION_01.setTradeId("T1");
    TRADE_WITH_VERSION_01.setVersion(1);
    TRADE_WITH_VERSION_01.setMaturityDate(LocalDate.now().plusDays(1));
    TRADE_WITH_VERSION_01.setExpired(false);
    
    TRADE_WITH_OLDER_MATURITY_DATE.setTradeId("T1");
    TRADE_WITH_OLDER_MATURITY_DATE.setVersion(1);
    TRADE_WITH_OLDER_MATURITY_DATE.setMaturityDate(LocalDate.now().minusDays(1));
    TRADE_WITH_OLDER_MATURITY_DATE.setExpired(false);
  }
}
