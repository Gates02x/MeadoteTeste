package com.pet.Meadote.Controller;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Models.Usuario;
import com.pet.Meadote.Service.UsuarioService;
import com.pet.Meadote.Utils.SuccessFulMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity criarConta (@RequestBody Usuario usuario){
        Usuario contaCriada = usuarioService.CriarConta(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessFulMessages.SuccesFullCreatedUser(usuario.getNomeUsuario()));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findByIdDto(id);
        return ResponseEntity.ok(usuarioDTO);
    }
}