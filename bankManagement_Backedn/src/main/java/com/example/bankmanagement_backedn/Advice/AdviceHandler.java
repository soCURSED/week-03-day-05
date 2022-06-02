package com.example.bankmanagement_backedn.Advice;

import com.example.bankmanagement_backedn.DTO.API;
import com.example.bankmanagement_backedn.exception.InvalidIDException;
import com.example.bankmanagement_backedn.exception.NoFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity InvalidIDException(InvalidIDException E){
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error,400));
    }

    @ExceptionHandler(NoFundsException.class)
    public ResponseEntity NoFundsException(NoFundsException E){
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error,400));
    }
}
