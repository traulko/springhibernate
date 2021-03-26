package com.innowise.springhibernate.controller.handlers;

import com.innowise.springhibernate.exception.ApiEntityException;
import com.innowise.springhibernate.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiException exception) {
        return ResponseEntity.badRequest().body(createApiError(exception));
    }

    private ApiEntityException createApiError(ApiException e) {
        return new ApiEntityException(e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());
    }
}
