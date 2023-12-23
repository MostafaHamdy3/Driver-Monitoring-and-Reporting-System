package com.dmrs.demo.exception;

import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

public record ApiException(String message, HttpStatus httpStatus,
                           ZonedDateTime timestamp) {

}
