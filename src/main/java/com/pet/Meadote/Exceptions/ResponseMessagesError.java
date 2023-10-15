package com.pet.Meadote.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseMessagesError {

    private String message;

    public static ResponseMessagesError NotFoundIdUser (Long id) {
        return new ResponseMessagesError
                ("Usuario não encontrado" + id);
    }
}
