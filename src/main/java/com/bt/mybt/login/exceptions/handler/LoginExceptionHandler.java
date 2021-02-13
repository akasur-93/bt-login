package com.bt.mybt.login.exceptions.handler;

import com.bt.mybt.login.exceptions.BadCredentialsException;
import com.bt.mybt.login.exceptions.error.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class LoginExceptionHandler {

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Error> handleGenericNotFoundException(BadCredentialsException e) {

        Error error = new Error("Unauthorised", e.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        error.setStatus((HttpStatus.UNAUTHORIZED.value()));
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
