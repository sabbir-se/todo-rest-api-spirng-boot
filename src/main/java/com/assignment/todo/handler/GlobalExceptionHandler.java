package com.assignment.todo.handler;

import com.assignment.todo.exception.CustomException;
import com.assignment.todo.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Created by sabbir on 12/2/21.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(CustomException customException) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(customException.getMessage());
        response.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.valueOf(customException.getCode()));
    }
}
