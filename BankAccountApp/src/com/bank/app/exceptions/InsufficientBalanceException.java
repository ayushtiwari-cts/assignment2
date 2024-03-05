package com.bank.app.exceptions;

//Create exception class InsufficientBalanceException which extends Exception and logs error.
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
        System.out.println("Insufficient Balance error occrred.");
    }    
}
