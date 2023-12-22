package com.dmrs.demo.exception;

public enum ErrorCode {
  USER_NOT_FOUND_EXCEPTION(1),
  EMAIL_ALREADY_EXISTS(2),
  EMAIL_NOT_VALID(3),
  EMAIL_NOT_FOUND(4),
  INVALID_REQUEST_BODY(5),
  AUTHENTICATION_EXCEPTION(6),
  DEACTIVATED_ACCOUNT(7),
  INVALID_AUTHORIZATION_TOKEN(8),
  UNKNOWN_SERVER_ERROR(100);

  private final int code;
  ErrorCode(int code)
  {
    this.code = code;

  }

  public int getCode()
  {
    return code;
  }



}
