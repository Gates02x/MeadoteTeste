package com.pet.Meadote.Service;

import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

private final UsuarioRepository usuarioRepository;

public  Usuario CriarConta (Usuario usuario) {
    return usuarioRepository.save(usuario);
}

}
