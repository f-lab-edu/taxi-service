package com.giwankim.taxiservice.core.api.controller;

import com.giwankim.taxiservice.core.api.support.error.CoreApiException;
import com.giwankim.taxiservice.core.api.support.error.ErrorType;
import com.giwankim.taxiservice.core.api.support.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApiControllerAdvice {

  private static final Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

  @ExceptionHandler(CoreApiException.class)
  public ResponseEntity<ApiResponse<?>> handleCoreApiException(CoreApiException e) {
    switch (e.getErrorType().getLogLevel()) {
      case ERROR -> logger.error("CoreApiException : {}", e.getMessage(), e);
      case WARN -> logger.warn("CoreApiException : {}", e.getMessage(), e);
      default -> logger.info("CoreApiException : {}", e.getMessage(), e);
    }
    return new ResponseEntity<>(ApiResponse.error(e.getErrorType(), e.getData()), e.getErrorType().getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    logger.info("MethodArgumentNotValidException : {}", e.getMessage());
    List<String> errorMessages = e.getBindingResult()
      .getAllErrors()
      .stream()
      .map(DefaultMessageSourceResolvable::getDefaultMessage)
      .toList();
    return new ResponseEntity<>(ApiResponse.error(ErrorType.BAD_REQUEST, errorMessages), ErrorType.BAD_REQUEST.getStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
    logger.error("Exception : {}", e.getMessage(), e);
    return new ResponseEntity<>(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getStatus());
  }
}
