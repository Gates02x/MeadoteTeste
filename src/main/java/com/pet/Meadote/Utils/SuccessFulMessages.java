package com.pet.Meadote.Utils;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Exceptions.UsuarioNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SuccessFulMessages {

    private String message;

    public static String SuccesFullCreatedUser (String usuario) {
        return "Usuario " + usuario + " criado com sucesso";
    }
}
