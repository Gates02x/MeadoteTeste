package com.pet.Meadote.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetPostDTO {

    private Long idPost;
    private String petName;
    private String comment;
    private UsuarioDTO usuario;
}