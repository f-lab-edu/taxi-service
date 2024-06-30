package com.giwankim.taxiservice.core.api.config;

import com.giwankim.taxiservice.core.api.support.error.CoreApiException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public void handleUncaughtException(Throwable e, Method method, Object... params) {
    if (e instanceof CoreApiException cae) {
      switch (cae.getErrorType().getLogLevel()) {
        case ERROR -> logger.error("CoreApiException : {}", cae.getMessage(), cae);
        case WARN -> logger.warn("CoreApiException : {}", cae.getMessage(), cae);
        default -> logger.info("CoreApiException : {}", cae.getMessage(), cae);
      }
    } else {
      logger.error("Exception : {}", e.getMessage(), e);
    }
  }
}
