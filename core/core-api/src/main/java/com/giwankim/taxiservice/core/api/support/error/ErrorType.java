package com.giwankim.taxiservice.core.api.support.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

  DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.E500, "예상치 못한 에러가 발생했습니다.", LogLevel.ERROR),
  BAD_REQUEST(HttpStatus.BAD_REQUEST, ErrorCode.E400, "요청 변수를 확인해 주세요.", LogLevel.INFO);

  private final HttpStatus status;
  private final ErrorCode code;
  private final String message;
  private final LogLevel logLevel;
}
