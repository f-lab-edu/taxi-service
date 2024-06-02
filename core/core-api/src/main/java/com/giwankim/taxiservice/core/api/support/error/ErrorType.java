package com.giwankim.taxiservice.core.api.support.error;

import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
  BAD_REQUEST(HttpStatus.BAD_REQUEST, ErrorCode.E400, "요청 변수를 확인해 주세요.", LogLevel.ERROR),
  NOT_FOUND(HttpStatus.NOT_FOUND, ErrorCode.E404, "해당 경로가 존재하지 않습니다.", LogLevel.ERROR),
  METHOD_NOT_ALLOWED(
      HttpStatus.METHOD_NOT_ALLOWED, ErrorCode.E405, "지원하지 않는 HTTP 메소드입니다.", LogLevel.ERROR),
  DEFAULT_ERROR(
      HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.E500, "예상치 못한 에러가 발생했습니다.", LogLevel.ERROR);

  private final HttpStatus status;
  private final ErrorCode code;
  private final String message;
  private final LogLevel logLevel;

  ErrorType(HttpStatus status, ErrorCode code, String message, LogLevel logLevel) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.logLevel = logLevel;
  }
}
