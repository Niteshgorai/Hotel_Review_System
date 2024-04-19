package com.Spring.User.Service.UserService.exception;

import com.Spring.User.Service.UserService.exception.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourseNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
