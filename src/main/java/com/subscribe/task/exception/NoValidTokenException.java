package com.subscribe.task.exception;

public class NoValidTokenException extends RuntimeException{
    public NoValidTokenException(String message){
        super(message);
    }
}
