package com.assignment.todo.exception;

/**
 * Created by sabbir on 12/2/21.
 */
public class CustomException extends Exception {

    private int code;
    private String message;

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
