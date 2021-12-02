package com.assignment.todo.exception;

import java.time.LocalDateTime;

/**
 * Created by sabbir on 12/2/21.
 */
public class ExceptionResponse {

    private String message;
    private LocalDateTime dateTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
