package com.pet.Meadote.Exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> handleUsuarioNotFoundException(UsuarioNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

