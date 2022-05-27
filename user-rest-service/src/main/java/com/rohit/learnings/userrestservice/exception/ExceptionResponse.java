package com.rohit.learnings.userrestservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private final Date date;
    private final String exceptionMessage;
    private final String exceptionDetails;

}
