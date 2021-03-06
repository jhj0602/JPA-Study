package com.ssafy.study.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(BindException e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudyException.class)
    public ResponseEntity<ErrorResponse> serverExceptionHandler(StudyException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

}
