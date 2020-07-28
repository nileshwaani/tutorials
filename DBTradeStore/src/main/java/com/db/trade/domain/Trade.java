package com.db.trade.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRADES")
public class Trade {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long internalId;
  private String tradeId;
  private Integer version;
  private String counterPartyId;
  private String bookId;
  private LocalDate maturityDate;
  private LocalDate createdDate;
  private boolean expired;

  public Long getInternalId() {
    return internalId;
  }

  public void setInternalId(Long internalId) {
    this.internalId = internalId;
  }

  public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getCounterPartyId() {
    return counterPartyId;
  }

  public void setCounterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public LocalDate getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public boolean isExpired() {
    return expired;
  }

  public void setExpired(boolean expired) {
    this.expired = expired;
  }
}
