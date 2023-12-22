package com.dmrs.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApiException {
  private final ErrorCode errorCode;
  private final String message;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;

  public ApiException(ErrorCode errorCode, String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
    this.errorCode = errorCode;
    this.message = message;
    this.httpStatus = httpStatus;
    this.timestamp = timestamp;
  }

}
