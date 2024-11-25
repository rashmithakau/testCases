package com.demo.Demo.advisor;

import com.demo.Demo.exception.NotFoundException;
import com.demo.Demo.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(404,"Error",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleException(Exception e) {
        return new ResponseEntity<>(
                new StandardResponse(500,"Error",e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
