package com.pet.Meadote.Mapper;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO (Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getIdUsuario());
        usuarioDTO.setNomeUsuario(usuario.getNomeUsuario());
        usuarioDTO.setTelefoneUsuario(usuario.getTelefoneUsuario());
        usuarioDTO.setEmail(usuario.getEmail());
        return usuarioDTO;

    }
}
