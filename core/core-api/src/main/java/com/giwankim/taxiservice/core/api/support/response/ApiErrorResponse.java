package com.giwankim.taxiservice.core.api.support.response;

import com.giwankim.taxiservice.core.api.support.error.ErrorMessage;
import com.giwankim.taxiservice.core.api.support.error.ErrorType;
import lombok.Getter;

@Getter
public class ApiErrorResponse {
  private final ResultType result;
  private final Object data = null;
  private final ErrorMessage error;

  public ApiErrorResponse(ResultType result, ErrorMessage error) {
    this.result = result;
    this.error = error;
  }

  public static ApiErrorResponse of(ErrorType errorType) {
    return new ApiErrorResponse(ResultType.ERROR, new ErrorMessage(errorType));
  }

  public static ApiErrorResponse of(ErrorType errorType, Object errorData) {
    return new ApiErrorResponse(ResultType.ERROR, new ErrorMessage(errorType, errorData));
  }
}
