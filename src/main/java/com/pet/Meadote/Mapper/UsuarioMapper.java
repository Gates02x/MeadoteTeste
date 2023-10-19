package com.pet.Meadote.Mapper;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Models.UsuarioLogin;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO (UsuarioLogin usuarioLogin) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioLogin.getIdUsuario());
        usuarioDTO.setNomeUsuario(usuarioLogin.getNomeUsuario());
        usuarioDTO.setTelefoneUsuario(usuarioLogin.getTelefoneUsuario());
        usuarioDTO.setEmail(usuarioLogin.getEmail());
        return usuarioDTO;

    }
}
