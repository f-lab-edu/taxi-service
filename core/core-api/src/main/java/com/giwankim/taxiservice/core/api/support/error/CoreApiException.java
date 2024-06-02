package com.giwankim.taxiservice.core.api.support.error;

import lombok.Getter;

@Getter
public class CoreApiException extends RuntimeException {
  private final ErrorType errorType;
  private final Object data;

  public CoreApiException(ErrorType errorType) {
    this(errorType, null);
  }

  public CoreApiException(ErrorType errorType, Object data) {
    super(errorType.getMessage());
    this.errorType = errorType;
    this.data = data;
  }
}
