package com.dmrs.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
public class ApiRequestException extends RuntimeException {

  public ApiRequestException( String message) {
    super(message);
  }
  public ApiRequestException( String message , Throwable cause) {
    super(message, cause);

  }

}
