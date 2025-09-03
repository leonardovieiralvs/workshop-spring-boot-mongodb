package com.leosouza.workshopmongo.controller.exceptions;

public class ObjectNotFoundExcpetion extends RuntimeException {
    public ObjectNotFoundExcpetion(String message) {
        super(message);
    }
}
