package com.pet.Meadote.Mapper;

import com.pet.Meadote.DTO.PetPostDTO;
import com.pet.Meadote.Models.PetPost;
import com.pet.Meadote.Models.UsuarioLogin;
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
        petPostDTO.setIdadePet(petPost.getIdadePet());
        petPostDTO.setTamanhoPet(petPost.getTamanhoPet());
        petPostDTO.setCidadePet(petPost.getCidadePet());
        petPostDTO.setComment(petPost.getComentario());
        petPostDTO.setImageName(petPost.getImageName());

        petPostDTO.setUsuario(usuarioMapper.toDTOUser(petPost.getUsuarioLogin()));

        return petPostDTO;
    }


    public PetPost toEntity(String petName, String comment, Long idadePet, String tamanhoPet, String cidadePet, UsuarioLogin usuarioLogin) {
        PetPost petPost = new PetPost();
        petPost.setNomePet(petName);
        petPost.setComentario(comment);
        petPost.setIdadePet(idadePet);
        petPost.setTamanhoPet(tamanhoPet);
        petPost.setCidadePet(cidadePet);
        petPost.setUsuarioLogin(usuarioLogin);
        return petPost;
    }

}

