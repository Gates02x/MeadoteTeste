package com.pet.Meadote.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String message) {
        super(message);

    }

    public static String NotFoundUserId (Long id) {
        return "Usuario com id " + id + " Não encontrado";
    }
    public static String NotFoundPostId (Long id) {
        return "Post com id " + id + " Não encontrado";
    }
}