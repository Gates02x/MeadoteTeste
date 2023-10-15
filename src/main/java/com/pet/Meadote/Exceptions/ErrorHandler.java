package com.pet.Meadote.Exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorHandler {

    private String campo;
    private String message;
}
