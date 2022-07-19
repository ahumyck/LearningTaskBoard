package com.evgeniy.task.exception;

public class NoRewardException extends IllegalArgumentException{
    public NoRewardException(String description){
        super(description);
    }
}
