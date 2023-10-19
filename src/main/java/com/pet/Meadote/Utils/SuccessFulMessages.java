package com.pet.Meadote.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SuccessFulMessages {

    private String message;

    public static String SuccesFullCreatedUser (String usuario) {
        return "UsuarioLogin " + usuario + " criado com sucesso";
    }

    public static String SuccesFullDeletedUser (Long usuario) {
        return "UsuarioLogin " + usuario + " deletado com sucesso";
    }
}
