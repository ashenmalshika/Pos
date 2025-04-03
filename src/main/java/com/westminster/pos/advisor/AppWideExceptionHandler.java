package com.westminster.pos.advisor;

import com.westminster.pos.controller.CustomerController;
import com.westminster.pos.exception.NotFoundException;
import com.westminster.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(404, "Error Coming", e.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
