package com.pet.Meadote.Utils;

import com.pet.Meadote.Exceptions.ResponseMessagesError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SuccessFulMessages {

    private String message;

    public static ResponseMessagesError SuccesFullCreatedUser ( String usuario) {
        return new ResponseMessagesError
                ("Usuario "+usuario+" criado com sucesso");
    }
}
