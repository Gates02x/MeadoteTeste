package com.pet.Meadote.Mapper;

import com.pet.Meadote.DTO.PetPostDTO;
import com.pet.Meadote.Models.PetPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Component
public class PetPostMapper {

    private final UsuarioMapper usuarioMapper;

    public PetPostDTO toDTOPost(PetPost petPost) {
        PetPostDTO petPostDTO = new PetPostDTO();
        petPostDTO.setIdPost(petPost.getIdPost());
        petPostDTO.setPetName(petPost.getNomePet());
        petPostDTO.setComment(petPost.getComentario());
        petPostDTO.setImageName(petPost.getImageName());

        petPostDTO.setUsuario(usuarioMapper.toDTO(petPost.getUsuarioLogin()));

        return petPostDTO;
    }
}

