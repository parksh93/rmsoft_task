package com.subscribe.task.exception;

public class NotMatchAmountException extends RuntimeException{
    public NotMatchAmountException(String message){
        super(message);
    }
}
