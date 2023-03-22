package com.api.ascii.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value  = {ApiRequestException.class})
    public ResponseEntity<Object> exceptionHandler(ApiRequestException exception) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        HttpStatusCode statusCode =  HttpStatusCode.valueOf(400);

        RequestException reqException = new RequestException(
                exception.getMessage(),
                badRequest,
                statusCode
        );

         return new  ResponseEntity<>(reqException, badRequest);
    }
}
