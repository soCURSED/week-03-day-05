package com.example.bankmanagement_backedn.exception;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message) {
        super(message);
    }
}
