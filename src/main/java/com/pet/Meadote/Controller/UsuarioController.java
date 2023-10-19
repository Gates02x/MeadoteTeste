package com.pet.Meadote.Controller;

import com.pet.Meadote.DTO.UsuarioDTO;
import com.pet.Meadote.Models.UsuarioLogin;
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
    public ResponseEntity criarConta (@RequestBody UsuarioLogin usuarioLogin){
        UsuarioLogin contaCriada = usuarioService.createAccount(usuarioLogin);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessFulMessages.SuccesFullCreatedUser(usuarioLogin.getNomeUsuario()));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId( @PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findByIdDto(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping(value = "delete/{idUsuario}",produces = "application/json")
    public ResponseEntity<String> deleteByIdUser (@PathVariable("idUsuario") Long idUsuario){
        usuarioService.deleteUsuarioById(idUsuario);
        return ResponseEntity.ok(SuccessFulMessages.SuccesFullDeletedUser(idUsuario));
    }
}