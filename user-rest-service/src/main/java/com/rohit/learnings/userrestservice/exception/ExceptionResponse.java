package com.rohit.learnings.userrestservice.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {

    private final Date date;
    private final String exceptionMessage;
    private final String exceptionDetails;

    public ExceptionResponse(Date date, String exceptionMessage, String exceptionDetails) {
        this.date= date;
        this.exceptionMessage = exceptionMessage;
        this.exceptionDetails = exceptionDetails;
    }
}
