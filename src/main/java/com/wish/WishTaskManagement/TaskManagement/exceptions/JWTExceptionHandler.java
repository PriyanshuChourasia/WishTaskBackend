package com.wish.WishTaskManagement.TaskManagement.exceptions;

public class JWTExceptionHandler extends RuntimeException {
    public JWTExceptionHandler(String message) {
        super(message);
    }
}
