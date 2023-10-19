package com.pet.Meadote.Service;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Exceptions.MessageNotFoundException;
import com.pet.Meadote.Mapper.UsuarioMapper;
import com.pet.Meadote.Models.UsuarioLogin;
import com.pet.Meadote.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public UsuarioLogin createAccount(UsuarioLogin usuarioLogin) {
        return usuarioRepository.save(usuarioLogin);
    }


    public UsuarioDTO findByIdDto(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow(() -> new MessageNotFoundException(MessageNotFoundException.NotFoundUserId(id)));
    }

    public void deleteUsuarioById(Long idUsuario) {
        usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new MessageNotFoundException(MessageNotFoundException.NotFoundUserId(idUsuario)));
        usuarioRepository.deleteById(idUsuario);
    }
}