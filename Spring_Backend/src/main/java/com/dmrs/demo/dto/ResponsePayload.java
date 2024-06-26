package com.dmrs.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePayload {
    private HttpStatus code;
    private String successMessage;
    private String errorMessage;
    private Date time;
    private Map<?,?> data;
}
