package com.example.summerpractice.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType) {
        super(String.format("Entity %s not found", entityType));
    }
}
