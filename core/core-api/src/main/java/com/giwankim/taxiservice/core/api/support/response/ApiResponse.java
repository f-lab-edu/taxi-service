package com.giwankim.taxiservice.core.api.support.response;

import com.giwankim.taxiservice.core.api.support.error.ErrorMessage;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
  private final ResultType result;
  private final T data;
  private final ErrorMessage error;

  public ApiResponse(ResultType result, T data, ErrorMessage error) {
    this.result = result;
    this.data = data;
    this.error = error;
  }

  public static ApiResponse<?> success() {
    return new ApiResponse<>(ResultType.SUCCESS, null, null);
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(ResultType.SUCCESS, data, null);
  }
}
