package com.pet.Meadote.Exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExption {

@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(MethodArgumentNotValidException.class)
public List<ErrorHandler> handle (MethodArgumentNotValidException exception){
    List<FieldError> fieldErrorList =
            exception.getBindingResult().getFieldErrors();
    List<ErrorHandler> list = new ArrayList<>();

    fieldErrorList.forEach(fieldError ->
            list.add(new ErrorHandler(fieldError.getField(),
                    fieldError.getDefaultMessage())));
     return list;
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotAllowed(Exception ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Método HTTP não permitido: " + ex.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNotFound(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado: " + ex.getRequestURL());
    }
}
