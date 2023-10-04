package com.pet.Meadote.Service;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Mapper.UsuarioMapper;
import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public Usuario CriarConta(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public UsuarioDTO findByIdDto(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return usuarioMapper.toDTO(usuario);
        }
        return null;
    }
}