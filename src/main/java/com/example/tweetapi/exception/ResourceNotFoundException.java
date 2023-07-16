package com.example.tweetapi.exception;

public class ResourceNotFoundException extends RuntimeException{
    private long fieldValue;

    public ResourceNotFoundException(long fieldValue) {
        super(String.format("User or Tweet not found with ID: '%s'",fieldValue));
        this.fieldValue = fieldValue;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
