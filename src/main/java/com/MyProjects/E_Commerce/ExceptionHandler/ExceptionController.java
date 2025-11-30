package com.MyProjects.E_Commerce.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController
{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound (NotFoundException notFoundException)
    {
         ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
         return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> alreadyExist (AlreadyExistsException alreadyExistsException)
    {
        ErrorResponse errorResponse = new ErrorResponse(alreadyExistsException.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);

    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ErrorResponse> outOfStock (OutOfStockException outOfStockException)
    {
        ErrorResponse errorResponse = new ErrorResponse(outOfStockException.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

}
