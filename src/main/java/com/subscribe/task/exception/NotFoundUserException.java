package com.subscribe.task.exception;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(String message){
        super(message);
    }
}
