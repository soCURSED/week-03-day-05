package com.example.bankmanagement_backedn.exception;

public class NoFundsException extends RuntimeException{
    public NoFundsException(String message) {
        super(message);
    }
}