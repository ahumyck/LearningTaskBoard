package com.evgeniy.task.exception.empty;

public class CollectionNotEmptyException extends NotEmptyException{
    public CollectionNotEmptyException(String description) {
        super(description);
    }
}
