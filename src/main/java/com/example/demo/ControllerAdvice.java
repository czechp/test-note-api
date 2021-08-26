package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice()
class ControllerAdvice {
    @ExceptionHandler({NoteNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void noteNotFoundExceptionHandler() {

    }
}
