package com.albee.mydataapi.common.exception;

import com.albee.mydataapi.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(EmailDuplicateException.class)
//    public ResponseEntity<ErrorResponse> handleEmailDuplicateException(EmailDuplicateException ex){
//        log.error("handleEmailDuplicateException",ex);
//        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
//    }

//    @ExceptionHandler(ClientAbortException.class)
//    public ResponseEntity<Response> handleClientAbortException(ClientAbortException ex){
//        return ClientAbortException;
//    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){

        if(!ex.getClass().getName().equals("org.apache.catalina.connector.ClientAbortException")) {
            log.error("handleException",ex);
        }
        // ErrorResponse response = new ErrorResponse(ErrorCode.INTER_SERVER_ERROR);
        // return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        MyDataApiException e = (MyDataApiException)ex;
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.resolve(response.getStatus()));
    }
}