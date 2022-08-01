package com.evgeniy.task.exception.empty;

import java.io.Serial;

public class NotEmptyException extends RuntimeException {
    public NotEmptyException(String description){
        super(description);
    }

}
