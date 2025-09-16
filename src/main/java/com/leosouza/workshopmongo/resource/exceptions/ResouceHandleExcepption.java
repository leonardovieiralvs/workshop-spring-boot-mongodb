package com.leosouza.workshopmongo.resource.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResouceHandleExcepption extends RuntimeException {


    @ExceptionHandler(ObjectNotFoundExcpetion.class)
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundExcpetion e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado", request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
