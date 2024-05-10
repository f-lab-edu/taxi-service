package com.giwankim.taxiservice.core.api.support.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorMessage {
  private final String code;
  private final String message;
  private final Object data;

  public ErrorMessage(ErrorType errorType) {
    this(errorType, null);
  }

  public ErrorMessage(ErrorType errorType, Object data) {
    this(errorType.getCode().name(), errorType.getMessage(), data);
  }
}
