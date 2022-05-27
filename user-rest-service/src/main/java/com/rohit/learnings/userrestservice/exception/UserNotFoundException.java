package com.rohit.learnings.userrestservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
