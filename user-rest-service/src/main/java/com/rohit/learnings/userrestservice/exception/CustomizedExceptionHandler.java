package com.rohit.learnings.userrestservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@SuppressWarnings("unused")
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request){
       ExceptionResponse exceptionResponse = new ExceptionResponse(
               new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
      ExceptionResponse exceptionResponse = new ExceptionResponse(
              new Date(),CommonExceptionMessages.VALIDATION_FAILED,exception.getBindingResult().toString());
      return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
