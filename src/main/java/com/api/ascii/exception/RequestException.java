package com.api.ascii.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public record RequestException(String message, HttpStatus status, HttpStatusCode statusCode) {
}
