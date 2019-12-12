package com.expenses.tracker.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String exception){
        super(exception);
    }
}
