package com.pet.Meadote.Service;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Exceptions.UsuarioNotFoundException;
import com.pet.Meadote.Mapper.UsuarioMapper;
import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public Usuario CriarConta(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public UsuarioDTO findByIdDto(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow(() -> new UsuarioNotFoundException(UsuarioNotFoundException.NotFoundUserId(id)));
    }
}