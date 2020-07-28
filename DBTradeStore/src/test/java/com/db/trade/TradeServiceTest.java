package com.db.trade;

import static com.db.trade.data.TradeTestData.TRADE_WITH_OLDER_MATURITY_DATE;
import static com.db.trade.data.TradeTestData.TRADE_WITH_VERSION_01;
import static com.db.trade.data.TradeTestData.VERSION_02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.db.trade.domain.Trade;
import com.db.trade.exception.ErrorCode;
import com.db.trade.exception.TradeStoreException;
import com.db.trade.repository.TradeRepository;
import com.db.trade.service.TradeService;

@ExtendWith(MockitoExtension.class)
class TradeServiceTest {

  @Mock
  private TradeRepository tradeRepository;

  @InjectMocks
  private TradeService tradeService;

  @Test
  void storingLowerVersionTradeShouldThrowException() {
    when(tradeRepository.getMaximumVersionForTrade(anyString())).thenReturn(VERSION_02);
    TradeStoreException exception = assertThrows(TradeStoreException.class, () -> {
      tradeService.storeTrade(TRADE_WITH_VERSION_01);
    });
    assertEquals(ErrorCode.LOWER_VERSION_ERROR, exception.getErrorCode());
  }

  @Test
  void storingExistingVersionTradeShouldOverrideExistingTrade() {
    tradeService.storeTrade(TRADE_WITH_VERSION_01);
    verify(tradeRepository).save(any(Trade.class));
  }

  @Test
  void storingOlderMaturityDateShouldThrowException() {
    TradeStoreException exception = assertThrows(TradeStoreException.class, () -> {
      tradeService.storeTrade(TRADE_WITH_OLDER_MATURITY_DATE);
    });
    assertEquals(ErrorCode.OLDER_MATURITY_DATE, exception.getErrorCode());
  }

  @Test
  void crossingMaturityDateShouldExpireTheTrade() {
    when(tradeRepository.getTradesWithCrossedMaturityDate(anyInt())).thenReturn(Arrays.asList(TRADE_WITH_OLDER_MATURITY_DATE)).thenReturn(Collections.emptyList());
    tradeService.expireTradesWithCrossedMaturityDate();
    assertEquals(true, TRADE_WITH_OLDER_MATURITY_DATE.isExpired());
    ArgumentCaptor<List<Trade>> argument = ArgumentCaptor.forClass(List.class);
    verify(tradeRepository).saveAll(argument.capture());
    assertEquals(true, argument.getValue().get(0).isExpired());
  }

}
