package com.dmrs.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApiRequestException extends RuntimeException {
  private final ErrorCode errorCode;

  public ApiRequestException( String message) {
    super(message);
    this.errorCode = ErrorCode.INVALID_REQUEST_BODY;
  }

  public ApiRequestException( String message , ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
  public ApiRequestException( String message , Throwable cause) {
    super(message, cause);
    this.errorCode = ErrorCode.INVALID_REQUEST_BODY;

  }

}
