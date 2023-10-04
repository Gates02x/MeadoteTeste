package com.pet.Meadote.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {

    private Long id;
    private String nomeUsuario;
    private String telefoneUsuario;
    private String email;

}
