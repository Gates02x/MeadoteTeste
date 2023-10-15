package com.pet.Meadote.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String message) {
        super(message);

    }

    public static String NotFoundUserId (Long id) {
        return "Usuario com id " + id + " Não encontrado";
    }
}