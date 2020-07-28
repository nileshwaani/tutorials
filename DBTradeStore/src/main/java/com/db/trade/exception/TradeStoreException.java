package com.db.trade.exception;

public class TradeStoreException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private ErrorCode errorCode;

  public TradeStoreException(ErrorCode errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }
}
