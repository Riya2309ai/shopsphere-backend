package com.riya.shopsphere.handler;


import com.riya.shopsphere.dto.ErrorResponse;
import com.riya.shopsphere.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(EmailAlreadyExistsException.class)
     public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex){

         ErrorResponse errorResponse = new ErrorResponse();
         errorResponse.setMessage(ex.getMessage());
         errorResponse.setStatus(HttpStatus.CONFLICT.value());
         errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
     }
}
