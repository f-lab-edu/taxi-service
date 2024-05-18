package com.giwankim.taxiservice.core.api.support.error;

import lombok.Getter;

@Getter
public class ErrorMessage {
  private final String code;
  private final String message;
  private final Object data;

  public ErrorMessage(String code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public ErrorMessage(ErrorType errorType) {
    this(errorType, null);
  }

  public ErrorMessage(ErrorType errorType, Object data) {
    this(errorType.getCode().name(), errorType.getMessage(), data);
  }
}
