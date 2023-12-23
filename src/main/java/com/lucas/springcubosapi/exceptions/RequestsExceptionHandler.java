package com.lucas.springcubosapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException ex) {
        ExceptionDTO response = new ExceptionDTO(ex.getMessage(), 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
