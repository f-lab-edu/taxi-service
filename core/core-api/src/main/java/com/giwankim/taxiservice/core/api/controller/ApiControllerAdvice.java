package com.giwankim.taxiservice.core.api.controller;

import com.giwankim.taxiservice.core.api.support.error.CoreApiException;
import com.giwankim.taxiservice.core.api.support.error.ErrorType;
import com.giwankim.taxiservice.core.api.support.response.ApiErrorResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ApiControllerAdvice {

  private static final Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

  @ExceptionHandler(CoreApiException.class)
  public ResponseEntity<ApiErrorResponse> handleCoreApiException(CoreApiException e) {
    switch (e.getErrorType().getLogLevel()) {
      case ERROR -> logger.error("CoreApiException : {}", e.getMessage(), e);
      case WARN -> logger.warn("CoreApiException : {}", e.getMessage(), e);
      default -> logger.debug("CoreApiException : {}", e.getMessage(), e);
    }
    return new ResponseEntity<>(
        ApiErrorResponse.of(e.getErrorType(), e.getData()), e.getErrorType().getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    logger.debug("MethodArgumentNotValidException : {}", e.getMessage(), e);
    List<String> errorMessages =
        e.getBindingResult().getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.BAD_REQUEST, errorMessages),
        ErrorType.BAD_REQUEST.getStatus());
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ApiErrorResponse> handleBindException(BindException e) {
    logger.debug("BindException : {}", e.getMessage(), e);
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.BAD_REQUEST), ErrorType.BAD_REQUEST.getStatus());
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ApiErrorResponse> handleMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException e) {
    logger.debug("MethodArgumentTypeMismatchException : {}", e.getMessage(), e);
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.BAD_REQUEST), ErrorType.BAD_REQUEST.getStatus());
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ApiErrorResponse> handleHttpRequestMethodNotSupportedException(
      HttpRequestMethodNotSupportedException e) {
    logger.debug("HttpRequestMethodNotSupportedException : {}", e.getMessage(), e);
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.METHOD_NOT_ALLOWED),
        ErrorType.METHOD_NOT_ALLOWED.getStatus());
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ApiErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
    logger.debug("NoHandlerFoundException : {}", e.getMessage(), e);
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.NOT_FOUND), ErrorType.NOT_FOUND.getStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiErrorResponse> handleException(Exception e) {
    logger.error("Exception : {}", e.getMessage(), e);
    return new ResponseEntity<>(
        ApiErrorResponse.of(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getStatus());
  }
}
