package com.app.easy2excel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistException(EmailAlreadyExistException exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){

        ErrorResponse error = new ErrorResponse(exp.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception exp){

        ErrorResponse error = new ErrorResponse(exp.getMessage(), HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());

        return new ResponseEntity<ErrorResponse> (error,HttpStatus.NOT_FOUND);
    }

}
